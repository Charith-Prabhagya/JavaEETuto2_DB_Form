<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
<!-- NEW Import JSTL Jar Files
1. Go to http://tomcat.apache.org/download-taglibs.cgi
2. Download taglibs-standard-spec-1.2.5.jar
3. Download taglibs-standard-impl-1.2.5.jar
4. Copy and paste into WebContent/WEB-INF/lib
5. Declare the taglib directive specifying the JSTL library
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!-- String Functions -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
<!-- Formatting Tags -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
 <!-- NEW DATABASE EXAMPLE 
 Below we use the JSP Expression Language to access attributes 
 of the customer object
 -->
 <h3>Thank you for the Info</h3>
 <label>First Name : </label>
 ${cust.fName}<br>
 <label>Last Name : </label>
 ${cust.lName}<br>
 <label>Phone : </label>
 ${cust.phone}<br>
 
 <!-- NEW JSP Standard Tag Library (JSTL)
 Many new tags are available for performing different tasks
 Create HTML based on a condition
  -->
  <c:if test="${cust.fName.equals('Derek')}">
  <p>Hi Derek</p>
  </c:if>
  
  <!-- Print an expression -->
  <c:out value = "Calculate"/><br>
  5 + 4 = <c:out value = "${5 + 4}"/><br>
  <c:out value = "${cust.fName}"/><br>
 
 <!-- Store a value -->
 <c:set var = "dogName" scope = "session" value = "Spot"/>
 <c:out value = "${dogName}"/><br>
 
 <!-- Delete a value -->
 <c:remove var = "dogName"/>
 
 <!-- Choose works like switch or if / else block -->
 <c:set var = "age" scope = "session" value = "8"/>
 <c:choose>
 	<c:when test = "${(age >= 5) && (age <= 6)}">
    	Go to Kindergarten
    </c:when>
         
    <c:when test = "${(age >= 7) && (age <= 13)}">
            Go to Middle School
         </c:when>
         
         <c:when test = "${(age >= 14) && (age <= 18)}">
            Go to High School
         </c:when>
         
         <c:otherwise>
            Stay home
         </c:otherwise>
 </c:choose><br>
 
 <!-- Iterate over a collection -->
 <c:forEach var = "i" begin = "1" end = "5" step = "2">
 	<c:out value = "${i}"/><br>
 </c:forEach>
 
 <c:forTokens items = "Tom,Sue,Ed" delims = "," var = "x">
 	<c:out value = "${x}"/><br>
 </c:forTokens>
 
 <!-- Exception handling -->
 <c:catch var = "divideByZeroException">
 	<% int ans = 2/0; %>
 </c:catch>
 
 <c:if test = "${divideByZeroException != null }">
 	Exception : ${divideByZeroException}<br>
 	${divideByZeroException }<br>
 </c:if>
 
 <!-- Load URL and pass a parameter value-->
 <c:url value = "index.jsp" var = "theURL">
   <c:param name = "passedParam" value = "passed value"/>
</c:url>
<c:import url = "${theURL }"/>
 
<!-- String Manipulation
Define a string -->
<c:set var = "str1" value = "a random string"/>
 
<!-- Turn into an array -->
<c:set var = "arr1" value = "${fn:split(str1, ' ')}" />
 
<!-- Turn back into a string -->
<c:set var = "str2" value = "${fn:join(arr1, ' ')}" />
 
<!-- Get length -->
Length : ${fn:length(str2)}<br>
 
<!-- Trim whitespace on front and end -->
<c:set var = "str2" value = "${fn:trim(str2)}" />
String : ${str2}<br>
 
<!-- Check if string contains a string -->
<c:if test = "${fn:contains(str2, 'random')}">
 
<!-- Get index of string -->
<!-- See also fn:containsIgnoreCase -->
Index : ${fn:indexOf(str2, "random")}<br>
 
<!-- Change value in string -->
<c:set var = "str2" value = "${fn:replace(str2, 'random', 'special')}" />
 
<!-- Get a substring -->
<c:set var = "str3" value = "${fn:substring(str2, 2, 9)}" />
 
<!-- To uppercase See also ${fn:toLowerCase(str3)} -->
<c:set var = "str3" value = "${fn:toUpperCase(str3)}" />
String : ${str3}<br>
 
</c:if>
 
<!-- Formatting Tags -->
<!-- Specify the the content type of a request -->
<fmt:requestEncoding value = "UTF-8" />
 
<!-- Store the locale using the ISO-639 language code and ISO-3166 
country code https://docs.oracle.com/cd/E13214_01/wli/docs92/xref/xqisocodes.html -->
<fmt:setLocale value = "en_US"/>
 
<!-- Get time -->
<c:set var = "nowTime" value = "<%=new java.util.Date()%>" />
 
<!-- Format date  
value : Date to display 
type : DATE, TIME, or BOTH
timestyle : FULL, LONG, MEDIUM, SHORT
datestyle : FULL, LONG, MEDIUM, SHORT
pattern : Custom formatting 
timeZone : -->
Date : <fmt:formatDate value = "${nowTime}" 
type = "BOTH" timeStyle = "LONG" dateStyle = "LONG" /><br>
 
<!-- Change the time zone -->
<fmt:setTimeZone value = "GMT" />
Date : <fmt:formatDate value = "${nowTime}" 
type = "BOTH" timeStyle = "LONG" dateStyle = "LONG" /><br>
 
Custom Date : <fmt:formatDate pattern = "hh:mm:ss:SS a z E MMMMM dd yyyy G" 
         value = "${nowTime}" dateStyle = "LONG" /><br>
         
<!-- Parse numbers, currencies and percents -->
<c:set var = "val1" value = "5000.89" />
 
<fmt:parseNumber var = "val2" type = "NUMBER" value = "${val1}" />
Number : <c:out value = "${val2}" /><br>
 
<!-- Format currency and use different locales -->
<fmt:setLocale value="fr_FR"/>
<fmt:formatNumber value="${val2}" type="CURRENCY" /><br>
<fmt:formatNumber value="${val2}" type="PERCENT"/><br>
 
 
</body>
</html>
