echo "starting script"
cd D:\ATAF_Projects\ATAF_Demo\ATAF_Demo
mvn clean test -Dcucumber.options="--tags @UniliverPaymentReqest"
echo "ending script"
pause