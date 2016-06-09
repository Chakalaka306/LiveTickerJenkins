# LiveTickerJenkins

testupload on readme

<datasource jta="false" jndi-name="java:jboss/datasources/LiveTickerDS" pool-name="MySqlDS" enabled="true" use-ccm="false">
                    <connection-url>jdbc:mysql://localhost:3306/mysqldb</connection-url>
                    <driver-class>com.mysql.jdbc.Driver</driver-class>
                    <driver>mysql-connector-java-5.1.38-bin.jar_com.mysql.jdbc.Driver_5_1</driver>
                    <security>
                        <user-name>root</user-name>
                        <password>1234</password>
                    </security>
                    <validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                        <background-validation>true</background-validation>
                        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
                    </validation>
                </datasource>