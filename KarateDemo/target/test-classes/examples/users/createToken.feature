Feature: Create Token
Scenario: Creating token
	Given url 'https://conduit-api.bondaracademy.com/api/'
	Given path 'users/login'
	And request {"user":{"email":"karatetest123@gmail.com","password":"karate1234"}}
	When method Post
	Then status 200
	* def authToken = response.user.token