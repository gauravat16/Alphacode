# Alphacode(previously Codesalad)

Welcome to Alphacode!

Alphacode is an online judge with support for C,C++ & java. with possible additions for newer languages(Star it for updates).

Installation :
             
  Pre Requisites-
     1.Linux OS
     2.Tomcat V8 or above
     3.MySql 5.6 or above
     4.Gcc G++ & Java8 compilers
              
  Creating Directories-
    1. Open Terminal [ctrl+alt+t]
    2. Enter the following Commands
       a. cd ~
       b. Open Installation-files Folder from Source Code
       c. chmod u+x MakeDir.sh
       d. Copy Sample data to CodeSalad Folder you just created.
                 
  Importing Project-     
           
    1. Import the alphacodeV1[beta].sql Database.
    2. Import the AlphaCodeV1[beta].war into Tomcat8 installation.
    3. Go the the Tomcat installation and goto tomcat/webapps/CodeSalad/WEB-INF/Configuration.txt
    4. Change the username 'gaurav' to the name of the user of your linux OS . [command- whoami in terminal]
    5. Change MySqlUserName & MySqlPassword to your MYSQL Credentials.
    6. Edit Severs.xml of tomcat8 and add this
       <Context docBase="/home/<your linux username>/CodeSalad/profile" path="/profile" reloadable="true"/>
       eg: <Context docBase="/home/gaurav/CodeSalad/profile" path="/profile" reloadable="true"/>
            before </Host> Tag.
                  
Screenshots:

  ![alt tag](https://github.com/gauravat16/CodeSalad/blob/master/Screenshots/Screenshot%20(12).png)
            
  ![alt tag](https://github.com/gauravat16/CodeSalad/blob/master/Screenshots/Screenshot%20(8).png)
            
  ![alt tag](https://github.com/gauravat16/CodeSalad/blob/master/Screenshots/Screenshot%20(13).png)
      
  ![alt tag](https://github.com/gauravat16/CodeSalad/blob/master/Screenshots/Screenshot%20(14).png)
            
  ![alt tag](https://github.com/gauravat16/CodeSalad/blob/master/Screenshots/Screenshot%20(15).png)
            
  ![alt tag](https://github.com/gauravat16/CodeSalad/blob/master/Screenshots/Screenshot%20(16).png)
           
                
             
             
             

