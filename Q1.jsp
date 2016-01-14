<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query Page</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>


<div class="main_wrap">
    <div id="leftlogo">

        <a href="main.html"> <img  src="logo.png" alt="logo"/> </a>

    </div>
    <div id="rightText">

        <h1>
            <a class="nav1" href="main.html">Home </a>
            <a class="nav1" href="Q1.jsp">MongoDB Careers</a>
            <a class="nav1" href="faqs.html">More..</a>
        </h1>
    </div>

</div>
<div class="wrapper_r">
    <br>
    <br>

    The resume selection criteria is dependent on the following parameters.

        <hr>
        <div id="leftContent">
           
            <form action="ServQuery1" method="post">


            <h3>University:</h3>
            <select name="univ" multiple>
                <option value="Rochester Institute of Technology">Rochester Institute of Technology</option>
                <option value="University of Southern California">University of Southern California</option>
                <option value="North eastern University">North eastern University</option>
                <option value="Chicago State University">Chicago State University</option>
            </select>
          

            <h3>Position type</h3>
            <select name="position type" multiple>
                <option value="internship">Internship</option>
                <option value="co-op">CO-OP</option>
                <option value="full-time">Full-time</option>
            </select>

            <h3>Skills required:</h3>
            <select name="skill" multiple>
                <option value="JAVA">JAVA</option>
                <option value="C++">C++</option>
                <option value="PHP">PHP</option>
                <option value="JavaScript">JavaScript</option>
                <option value="C#">C#</option>
                <option value="VB Script">VB Script</option>
            </select>

        </div>

        <div id="rightContent">
           
            <h4>Graduation Date: </h4>
            <select name="graduation" multiple>
                <option value="Dec 2015">Dec 2015</option>
                <option value="May 2016">May 2016</option>
                <option value="Dec 2016">Dec 2016</option>
                <option value="May 2017">May 2017</option>
            </select>


            <h4>GPA: </h4>
            <select name="GPA" multiple>
                <option value="Between 2.5-3.0">Between 2.5-3.0</option>
                <option value="Between 3.0-3.5">Between 3.0-3.5</option>
                <option value="Between 3.5-4.0 ">3.5-4.0</option>
            </select>
            <br> <br>
            <p>Work Experience</p>
            Number of years of experience: <input type="number" name="quantity" min="1" max="9"> <br>
            Programming language: <input type="text" name="language" value=""><br>
    <br>
    <select name="past-exp" multiple>
    <option value="same company">Intra-company Resumes</option>
    </select>
    <br>
    <br>
    
            <input type="submit" name="">

            </form>
        </div>
</div>



</body>
</html>