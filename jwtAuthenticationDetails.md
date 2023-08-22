JWT Authentication:
-------------------
User details are kept in InMemoryUserDetailsManager
e.g.
UserName : Akash 
password in console: Akash12345


Step 1: Make sure spring boot-security is added in pom.xml

Step 2: Implement JwtAuthenticationEntryPoint : This will be called whenever an exception is thrown
        due to unauthenticated user trying to access the resource that required authentication

Step 3: Create a JwtHelper to implement utilities like:
        getUsernameFromToken(String token)
        getExpirationDateFromToken(String token)
        getAllClaimsFromToken(String token)
        isTokenExpired(String token)
        generateToken(UserDetails userDetails)
                -> while creating the token -
                    1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
                    2. Sign the JWT using the HS512 algorithm and secret key.
                    3. According to JWS Compact Serialization
                        (https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
                        compaction of the JWT to a URL-safe string

Step 4: Create JWTAuthenticationFilter that extends OncePerRequestFilter and override method and write the logic to check the token that is comming in header. We have to write 5 important logic
            Get Token from request
            Validate Token
            GetUsername from token
            Load user associated with this token
            set authentication

Step 5: Configure spring security in configuration file:  create a bean securityFilterChain
                    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { ... }
Step 6: Create JWTRequest and JWTResponse to receive request data and send Login success response.

Step 7: Create login api to accept username and password and return token if username and password is correct.
