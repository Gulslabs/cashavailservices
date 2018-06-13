jar_exe=".jar";
for d in $(ls -d */);
do
 if [[ "$d" != common* ]] 	
 then
 	 directory=${d%%/};
	 directory+="/"
	 cd $directory
	 cd target		
	 echo 'Running target JAR from' $PWD;
	 jar_to_execute=${d%%/};
         jar_to_execute+=".jar";
	 echo $jar_to_execute; 	 	
	 nohup java -jar $jar_to_execute > /dev/null & 	  	
	 cd ..
	 cd ..	
 fi; 
done
