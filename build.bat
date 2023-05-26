jar cf java_framework.jar main_framework\bin
move "java_framework.jar" "testFramework\lib"


mkdir testing_framework\WEB-INF 
mkdir testing_framework\WEB-INF\classes 
mkdir testing_framework\WEB-INF\lib  

xcopy "testFramework\bin\*.class" "testing_framework\WEB-INF\classes"
xcopy "testFramework\lib\java_framework.jar" "testing_framework\WEB-INF\lib"

xcopy "main_framework\web.xml" "testing_framework\WEB-INF"
xcopy "testFramework\index.jsp" "testing_framework"

jar -cvf frameworkTest.war testing_framework

xcopy "frameworkTest.war" "C:\Program Files\Apache Software Foundation\Tomcat 9.0_Tomcat90\webapps"

rmdir testing_framework