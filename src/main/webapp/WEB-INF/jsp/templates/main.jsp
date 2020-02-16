<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>PLAFOO MAIN</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	
	<!--부트스트랩 css 추가-->
    <link rel="stylesheet" href="static/css/lib/bootstrap.min.css">
    
    <!-- HTTPS required. HTTP will give a 403 forbidden response -->
	<script src="https://sdk.accountkit.com/en_US/sdk.js"></script>

</head>
<body>


	<input value="+1" id="country_code" />
	<input placeholder="phone number" id="phone_number"/>
	<button onclick="smsLogin();">Login via SMS</button>
	<div>OR</div>
	<input placeholder="email" id="email"/>
	<button onclick="emailLogin();">Login via Email</button>

    


	
	<h1>PLAFOO is under construction</h1>
	
	<h2>junho@plafoo.com </h2>





	 <!--부트스트랩 js, jquery 추가-->
    <script src="static/js/lib/jquery.min.js"></script>
    <script src="static/js/lib/bootstrap.min.js"></script>
    
    <!--custom js 추가-->
    <script src="static/js/app/main.js"></script>
    
    
    <script>
  // initialize Account Kit with CSRF protection
  AccountKit_OnInteractive = function(){
    AccountKit.init(
      {
        appId:"{{FACEBOOK_APP_ID}}", 
        state:"{{csrf}}", 
        version:"{{ACCOUNT_KIT_API_VERSION}}",
        fbAppEventsEnabled:true,
        redirect:"{{REDIRECT_URL}}"
      }
    );
  };

  // login callback
  function loginCallback(response) {
    if (response.status === "PARTIALLY_AUTHENTICATED") {
      var code = response.code;
      var csrf = response.state;
      // Send code to server to exchange for access token
    }
    else if (response.status === "NOT_AUTHENTICATED") {
      // handle authentication failure
    }
    else if (response.status === "BAD_PARAMS") {
      // handle bad parameters
    }
  }

  // phone form submission handler
  function smsLogin() {
    var countryCode = document.getElementById("country_code").value;
    var phoneNumber = document.getElementById("phone_number").value;
    AccountKit.login(
      'PHONE', 
      {countryCode: countryCode, phoneNumber: phoneNumber}, // will use default values if not specified
      loginCallback
    );
  }


  // email form submission handler
  function emailLogin() {
    var emailAddress = document.getElementById("email").value;
    AccountKit.login(
      'EMAIL',
      {emailAddress: emailAddress},
      loginCallback
    );
  }
</script>

</body>
</html>