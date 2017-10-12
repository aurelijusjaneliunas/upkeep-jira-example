Configuring AWS
===============

### Create a security policy for IAM user
The IAM user will be used to create EC2 instances.

1. Open: <https://console.aws.amazon.com/iam/home>
2. Select your desired region. For the purpose of the example we will use `us-east-1`
3. Navigate to: Policies -> Create policy -> Create Your Own Policy
4. Copy the JSON contents from `gatling-aws-maven-plugin` example policy here: <https://github.com/electronicarts/gatling-aws-maven-plugin#aws-setup>
6. Don't forget to name the policy, for example: `GatlingMavenPlugin`
5. Click validate policy and then create

### Create a new user

1. Open: <https://console.aws.amazon.com/iam/home>
2. Select your desired region. Note that you will have to use the same region for all of the steps!
3. Create a new user, for example: `gatling-user` 
4. Add `GatlingMavenPlugin` to user's permissions.
5. Once created, go to `security credentails`
6. Create new access key and remember the access key id including secret key. You will need this!

### Create S3 bucket for uploading results

1. Open <https://s3.console.aws.amazon.com/s3/home>
2. Create a new bucket, for example: `gatling-bucket`

### Create your SSH keypair for EC2 instances

1. Open: <https://console.aws.amazon.com/ec2/v2/home>
2. Select your desired region. This must match your IAM user `gatling-user` region.
3. Navigate to: NETWORK & SECURITY -> Key Pairs 
4. Generate new key with any name desired, for example: `gatling-keypair`
5. The keypair will automatically start to download.
6. Move the key to safe folder, for example: `cp gatling-keypair.pem ~/.ssh/`
7. Run `chmod 500 ~/.ssh/gatling-keypair` to ensure no ssh warnings will pop-up

### Ensure that you have default VPC installed 

In case you don't have default VPC, create a customer ticket and ask AWS team
to create a default VPC for you. A default VPC is automatically created when you create a AWS account. However,
it cannot be manually created once deleted.

1. Open: <https://console.aws.amazon.com/vpc/home>
2. Navigate to Your VPCs
3. Under `default VPC` column, ensure that at least one of your VPCs is listed as `YES`

### Find AWS AMI ID

The AMI ID changes depending on your desired region. You can find out the AMI ID when you create
a new EC2 instance. For example For example: `ami-8c1be5f6` is `Amazon Linux AMI 2017.09.0 (HVM), SSD Volume Type` in region `us-east-1`

Now, at this point, you should have the following:
* An IAM user with access key ID + secret key and with custom policy
* A ssh-keypair stored on your computer
* S3 bucket 
* EC2 AMI ID