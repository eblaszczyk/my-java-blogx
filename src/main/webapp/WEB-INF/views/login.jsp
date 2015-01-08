<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
 	
 	<style>
		<%@ include file="../css/login.css" %>
	</style>

  </head>

  <body>

    <div class="container">

		<div style="max-width:330px">
	      <form class="form-signin" role="form"  action='/my-java-blogx/j_spring_security_check' method='POST'>
	        <h2 class="form-signin-heading">Please sign in</h2>
	        <input type="text" class="form-control" placeholder="Name"  name='j_username' required autofocus>
	        <input type="password"  class="form-control" placeholder="Password" name='j_password' required>

	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	      </form>
	    </div>
    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>