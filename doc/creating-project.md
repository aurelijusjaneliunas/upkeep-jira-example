Creating project
================

### Create a blank Gatling project using maven

1. Open command line
2. Go to the parent folder of your desired project location
3. Run `mvn generate`
4. When asked for `Choose a number or apply filter`, type `gatling`
5. You should now see a list of one item: `io.gatling.highcharts:gatling-highcharts-maven-archetype`, then type `1`
6. Choose your `groupId`, for example: `com.example`
7. Choose your `artifactId`, for example: `myLoadTest`

More information for generating Gatling project here: <https://gatling.io/docs/current/extensions/maven_archetype/>

### configure [gatling-aws-maven-plugin](https://github.com/electronicarts/gatling-aws-maven-plugin)
1. Create blank file `src/test/resources/config.properties`
2. Copy the following file: [install-gatling.sh from gatling-aws-maven-plugin](https://github.com/electronicarts/gatling-aws-maven-plugin/blob/master/examples/maven-example-loadtest-project/src/test/resources/install-gatling.sh) 
   into `src/test/resources/install-gatling.sh` and make sure the `GATLING_VERSION` matches the gatling version in your pom file!
3. Create `aws.properties` in the root folder of your project (where the pom.xml is) with the following two lines and paste in your access key ID
   and access secret.

```
accessKey=AWS_IAM_USER_ACCESS_KEY_ID
secretKey=AWS_IAM_USER_ACCESS_SECRET
```

Next, modify the pom.xml by adding the following properties:

```xml
<properties>
    <!-- Auto-generated gatling properties here -->
    
    <!-- Information required to start EC2 instances and control them via SSH -->
    <ssh.private.key>${user.home}/.ssh/gatling-keypair.pem</ssh.private.key>
    <ec2.key.pair.name>gatling-keypair</ec2.key.pair.name>
    <ec2.security.group>default</ec2.security.group>
    <ec2.instance.count>1</ec2.instance.count>
    <ec2.end.point>AWS_REGION_URL</ec2.end.point>
    <ec2.ami.id>AWS_REGION_SPECIFIC_AMI_ID</ec2.ami.id>
    <ec2.force.termination>true</ec2.force.termination>
    <ec2.keep.alive>false</ec2.keep.alive>
    
    <gatling.local.home>${project.basedir}/gatling/gatling-charts-highcharts-bundle-${gatling.version}/bin/gatling.sh</gatling.local.home>
    <gatling.install.script>${project.basedir}/src/test/resources/install-gatling.sh</gatling.install.script>
    <gatling.root>gatling-charts-highcharts-bundle-${gatling.version}</gatling.root>
    <gatling.java.opts>-Xms1g -Xmx4g</gatling.java.opts>
    
    <!-- S3 integration settings -->
    <s3.upload.enabled>true</s3.upload.enabled>
    <s3.bucket>gatling-tests</s3.bucket>
    <s3.subfolder>my-gatling-tests-results</s3.subfolder>
    
    <!-- other properties here -->
</properties>
```

* AWS_REGION_URL - This is the region name in URL form. The region must match the region you have chosen when creating ssh keypairs
  and AMI user. Example value: `https://ec2.us-east-1.amazonaws.com`
* AWS_REGION_SPECIFIC_AMI_ID - This is ID of AMI which is specific for each region. [How to find out AMI ID](configure-aws.md#find-aws-ami-id)

