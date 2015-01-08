<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="taglibs.jsp" %>    
    
<nav class="navbar navbar-default navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				 <span class="sr-only">Toggle navigation</span>
				 <span class="icon-bar"></span>
				 <span class="icon-bar"></span>
				 <span class="icon-bar"></span>
			</button>
		</div>
		
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
         		<li class="${current == 'home' ? 'active' : ''}">
         			<a href="<spring:url value="/" />">STRONA GŁÓWNA</a>
         		</li>
         		<li class="dropdown ${current == 'category' ? 'active' : ''}">
           			<a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
            			KATEGORIA
            			<span class="caret"></span>
          			</a>
           			<ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
           				<c:forEach items="${categories}"  var="cat">
             				<li role="presentation"><a role="menuitem" tabindex="" href="<spring:url value="/category/${cat.id}" />">${cat.categoryName}</a></li>
           				</c:forEach>
          			</ul>
        		</li>       
         		<li class="${current == 'about' ? 'active' : ''}" >
         			<a href="<spring:url value="/about" />">O MNIE</a>
         		</li>
         		<li class="${current == 'contact' ? 'active' : ''}" >
         			<a href="<spring:url value="/contact" />">KONTAKT</a>
         		</li>
         		<security:authorize access="isAuthenticated()">
	 				<li >&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </li>
	        		<security:authorize access="hasRole('ADMIN')">
	         			<li class="${current == 'users' ? 'active' : ''}" >
	         				<a href="<spring:url value="/users" />">Użytkownicy</a>
	         			</li>
	         		</security:authorize>
     
         			<li class="dropdown ${current == 'categories' ? 'active' : ''}">
         				<a href="<spring:url value="/categories" />">Kategorie</a>
         			</li>
         			<li class="dropdown ${current == 'posts' ? 'active' : ''}">
           				<a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
            				Posty
            				<span class="caret"></span>
          				</a>
           				<ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
          					<li role="presentation">
          						<a role="menuitem" tabindex="" href="<spring:url value="/posts/add/post" />">dodaj Post</a>
          					</li>
          					<li role="presentation">
          						<a role="menuitem" tabindex="" href="<spring:url value="/posts/myPosts" />">przeglądaj moje Posty</a>
          					</li>
          					<security:authorize access="hasRole('ADMIN')">
         	  					<li role="presentation">
         	  						<a role="menuitem" tabindex="" href="<spring:url value="/posts/allPosts" />">przeglądaj wszystkie Posty</a>
         	  					</li>
							</security:authorize>
						</ul>
	        		</li>
	        	
         			<li class="dropdown ${current == 'myaccount' ? 'active' : ''}">
           				<a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
            				Moje konto
            				<span class="caret"></span>
          				</a>
           				<ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
          					<li role="presentation">
          						<a role="menuitem" tabindex="" href="<spring:url value="/myaccount/view" />">Moje dane</a>
          					</li>
          					<li role="presentation">
          						<a role="menuitem" tabindex="" href="<spring:url value="/myaccount/change/password" />">
          							Zmień hasło
          						</a>
          					</li>
						</ul>
	        		</li>	        		
       		 		<li ><a href="<spring:url value="/logout" />">Logout</a></li>
 				</security:authorize>
			</ul>
<!--  ---------------------------------------------- -->	          	          
		</div><!-- /.nav-collapse -->
	</div><!-- /.container -->
</nav><!-- /.navbar -->
