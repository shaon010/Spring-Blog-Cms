<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.css">

<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="<spring:url value='/resources/css/responsive.css'/> ">
<link rel="stylesheet" href="<spring:url value='/resources/css/style.css'/> ">


<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script type="text/javascript"  src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<script type="text/javascript"  src="<spring:url value='/resources/js/modernizr-2.6.2.min.js'/> "></script>
<script type="text/javascript"  src="<spring:url value='/resources/js/general-actions.js'/> "></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>

<body>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="current"/>
<div class="wrapper">
    <header >
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <nav class="navbar">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button id="button" type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <i class="fa fa-bars"></i>
                            </button>
                            <!-- logo of header  -->
                            <a class="navbar-brand" href="<spring:url value="/" />">
                                <img src=<spring:url value="/resources/img/logo/logo.png"/> alt="blog logo">
                                <span>Made With Java || Blog</span>
                            </a>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users.html" />">Users</a></li>
                                </security:authorize>
                                <li class="${current == 'register' ? 'active' : ''} hidden"><a href="<spring:url value="/register.html" />">Register</a></li>
                                <security:authorize access="! isAuthenticated()">
                                    <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login.html" />">Login</a></li>
                                </security:authorize>
                                <security:authorize access="isAuthenticated()">
                                    <li class="${current == 'account' ? 'active' : ''}"><a href="<spring:url value="/account.html" />">My account</a></li>
                                    <li class="${current == 'postwrite' ? 'active' : ''}"><a href="<spring:url value="/postwrite.html" />">Write new blog post</a></li>
                                    <li><a href="<spring:url value="/logout" />">Logout</a></li>
                                </security:authorize>
                                <li class="dropdown category-dropdown active ">
                                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Category <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                    </ul>
                                </li>
                                <%--<li><a href="about.html" id="about">About</a></li>
                                <li><a href="credit.html" id="credit">Credit</a></li>--%>
                            </ul>
                        </div><!-- /.navbar-collapse -->
                    </nav><!--   End Nav -->
                </div>
            </div>
        </div>
        <div class="search">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!--     Page name on bar change below text-->
                        <div class="post-name">
                            <a href="#blog">Blog</a>
                        </div>
                        <div class="form">
                            <form action="" method="">
                                <i class="fa fa-search"></i>
                                <input type="text" placeholder="Search">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />
</div>

</body>
</html>