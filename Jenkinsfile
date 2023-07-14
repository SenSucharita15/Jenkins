node{
  stage('SCM Checkout')
  {
    git 'https://github.com/SenSucharita15/Jenkins.git'
  }
  stage('compile-package')
  {
    sh 'mvn package'
  }
}
