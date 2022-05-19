<?php

    class myAPI{
        
        private $nhsNo;
        private $firstname;
        private $lastname;
        private $dob;
        private $respiration;
        private $sp02;
        private $sp02scale;
        private $oxygen;
        private $bpresssure;
        private $pulse;
        private $cons;
        private $temp;
        private $finalscore;
        private $redflag;
        private $risk;
        private $response;
        private $time;
        private $nexttime;
        private $search;

        function __construct() {
            $this->mysqli = $mysqli;
        }
        
        //handle request
        public function handle_request() {
            switch ($_SERVER["REQUEST_METHOD"]) {
                case "POST":
                    $postReturn = $this->post();
                    echo $postReturn;
                    break;
                case "GET":
                    $getReturn = $this->get();
                    echo $getReturn;
                    break;
                default:
                    //no default
            }

        }
        
        function resultToArray($result){
            $rows = array();
            while($row = $result->fetch_assoc()) {
                $rows[] = $row;
            }
            return $rows;
        }
        
       
        //post request
        private function post() {
            
            //check that variables are set
           if(isset($_POST["nhsNo"]) 
            && isset($_POST["firstname"]) 
            && isset($_POST["lastname"]) 
            && isset($_POST["dob"])
            && isset ($_POST["respiration"]) 
            && isset($_POST["sp02"]) 
            && isset($_POST["sp02scale"]) 
            && isset($_POST["oxygen"]) 
            && isset($_POST["bloodpressure"]) 
            && isset($_POST["pulse"]) 
            && isset($_POST["cons"])
            && isset($_POST["temp"])
            && isset($_POST["finalscore"])
            && isset($_POST["redflag"]) 
            && isset($_POST["risk"])
            && isset($_POST["response"]) 
            && isset($_POST["redflag"]) 
            && isset($_POST["initials"])
            && isset($_POST["time"]) 
            && isset($_POST["nexttime"])) {
                
                try {
                    $mysqli = new mysqli('localhost', 'bd302_user_news', 'NEWSpass_', 'bd302_news_database'); //database login
                    echo 'Connection Secure', "\n"; 
                } catch (Exception $e) {
                    echo 'Caught exception: ', $e->getMessage(), "\n";
                }
                
                //assign values
                $nhsNo = $_POST['nhsNo'];
                $firstname = $_POST['firstname']; 
                $lastname = $_POST['lastname'];
                $dateofbirth = $_POST['dob'];
                $respiration = intval($_POST['respiration']); 
                $sp02 = intval($_POST['sp02']);
                $sp02scale = $_POST['sp02scale'];
                $oxygen = $_POST['oxygen'];
                $bloodpressure = intval($_POST['bloodpressure']);
                $pulse = intval($_POST['pulse']);
                $cons = $_POST['cons'];
                $temp = floatval($_POST['temp']);
                $finalscore = intval($_POST['finalscore']);
                $redflag = $_POST['redflag'];
                $risk = $_POST['risk'];
                $response = $_POST['response'];
                $initials = $_POST['initials'];
                $time = $_POST['time'];
                $nexttime = $_POST['nexttime'];
            
                //decode values
                urldecode($nhsNo);
                urldecode($firstname);
                urldecode($lastname);
                urldecode($dateofbirth);
                urldecode($respiration);
                urldecode($sp02);
                urldecode($sp02scale);
                urldecode($oxygen);
                urldecode($bpresssure);
                urldecode($pulse);
                urldecode($cons);
                urldecode($temp);
                urldecode($finalscore);
                urldecode($redflag);
                urldecode($risk);
                urldecode($response);
                urldecode($time);
                urldecode($nexttime);
                
                if($sp02scale == true) {
                    $sp02scale = 1;
                } else {
                    $sp02scale = 0;
                }
                
                
                if($redflag == true) {
                    $redflag = 1;
                } else if ($redFlag == false) {
                    $redflag = 0;
                }
                
                $sql = "INSERT INTO table1 (nhsNo, firstname, lastname, dob, respiration, sp02, sp02scale, oxygen, bloodpressure, pulse, cons, temp, finalscore, redflag, risk, response, initials, time, nexttime) VALUES ('$nhsNo', '$firstname', '$lastname', '$dateofbirth','$respiration', '$sp02', '$sp02scale', '$oxygen', '$bloodpressure', '$pulse', '$cons', '$temp', '$finalscore', '$redflag', '$risk', '$response', '$initials', '$time', '$nexttime')";
                $mysqli->query($sql);
                
                //close the database
                $mysqli->close(); 
                http_response_code(201);
                $result = " Record made";
                
                return $result;
            
            } else {
                //if things are not set return 400
                http_response_code(400);
                $result = " Record unsuccessful";
                return $result;
            }
        }
        private function get() {
            if(isset($_GET['search']) && isset($_GET['value'])){
                
                $type = $_GET['search'];
                $value = $_GET['value'];
                
                urldecode($type);
                urldecode($value);
                    
                if ($type == "NHS Number") {
                    $type = "nhsNo";
                } else if ($type == "First Name") {
                    $type = "firstname";
                } else if($type == "Last Name") {
                    $type = "lastname";
                } else if ($type == "Staff Initials") {
                    $type = "initials";
                }
                $mysqli = new mysqli('localhost', 'bd302_user_news', 'NEWSpass_', 'bd302_news_database');
                $sql = "SELECT * FROM table1 WHERE ".$type." = '".$value."' ORDER BY `table1`.`time` DESC";
                $result = $mysqli->query($sql);
                $array = $this->resultToArray($result);
                print_r(json_encode($array));
                //echo $result;
                mysqli_free_result($result);
            
                mysqli_close($mysqli);
            } else {
                http_response_code(404);
            }
                    
        }
    
    }
    //create a new MyAPI object
    $api = new MyAPI();
    $api->handle_request();
    
?>