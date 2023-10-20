<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign in & Sign up Form</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <main>
      <div class="box">
        <div class="inner-box">
          <div class="forms-wrap">
            <form action="<%=request.getContextPath()%>/login" method="post" autocomplete="off" class="sign-in-form">
              <div class="logo">
                <img src="./img/logo.png" alt="easyclass" />
                <h4>easypark</h4>
              </div>

              <div class="heading">
                <h2>Welcome Back</h2>
                <h6>Not registred yet?</h6>
                <a href="#" class="toggle">Sign up</a>
              </div>

              <div class="actual-form">
                <div class="input-wrap">
                  <input
                    type="email" 
                    class="input-field"
                    autocomplete="off"
                    required
                    name="email-login"
                  />
                  <label>Email</label>
                </div>

                <div class="input-wrap"> 
                  <input
                    type="password"
                    minlength="8"
                    class="input-field"
                    autocomplete="off"
                    required
                    name="pass-login"
                  />
                  <label>Password</label>
                </div>

                <input type="submit" value="Sign In" class="sign-btn" />

                <p class="text">
                  Forgot your password?
                  <a href="#">Get help</a> signing in
                </p>
              </div>
            </form>

            <form action="<%=request.getContextPath()%>/register" method="post" autocomplete="off" class="sign-up-form">
              <div class="logo">
                <img src="./img/logo.png" alt="easyclass" />
                <h4>easypark</h4>
              </div>

              <div class="heading">
                <h2>Get Started</h2>
                <h6>Already have an account?</h6>
                <a href="#" class="toggle">Sign in</a>
              </div>

              <div class="actual-form" id="sign-up">
                <div class="name-wrapper">
                  <div class="input-wrap" id = "fname">
                    <input
                      type="text"
                      minlength="4"
                      class="input-field"
                      autocomplete="off"
                      required
                      name="fname-reg"
                    />
                    <label>First Name</label>
                  </div> 
                  
                  <div class="input-wrap" id = "lname">
                    <input
                      type="text"
                      minlength="4"
                      class="input-field"
                      autocomplete="off"
                      required
                      name="lname-reg"
                    />
                    <label>Last Name</label>
                  </div>
                </div>

                <div class="input-wrap">
                  <input
                    type="text"
                    minlength="4"
                    class="input-field"
                    autocomplete="off"
                    required
                    name="phno-reg"
                  />
                  <label>Phone Number</label>
                </div>

                <div class="input-wrap">
                  <input
                    type="email"
                    class="input-field"
                    autocomplete="off"
                    required
                    name="email-reg"
                  />
                  <label>Email</label>
                </div>

                <div class="input-wrap">
                  <input
                    type="password"
                    minlength="8"
                    class="input-field"
                    autocomplete="off"
                    required
                    name="pass-reg"
                    id = "password"
                    onChange='onChange();'
                  />
                  <label>Password</label>
                </div>
                
                <div class="input-wrap">
                  <input
                    type="password"
                    minlength="8"
                    class="input-field"
                    autocomplete="off"
                    required
                    name="confirm_pass-reg"
                    id = "confirm_password"
                    onChange='onChange();'
                  />
                  <label>Confirm Password</label>
                </div>

                <input type="submit" value="Sign Up" class="sign-btn" />

                <p class="text">
                  By signing up, I agree to the
                  <a href="#">Terms of Services</a> and
                  <a href="#">Privacy Policy</a>
                </p>
              </div>
            </form>
          </div>

          <div class="carousel">
            <div class="images-wrapper">
              <img src="./img/image1.png" class="image img-1 show" alt="" />
              <img src="./img/image2.png" class="image img-2" alt="" />
              <img src="./img/image3.png" class="image img-3" alt="" />
            </div>

            <div class="text-slider">
              <div class="text-wrap">
                <div class="text-group">
                  <h2>Choose where you park</h2>
                  <h2>Priority based parking management</h2>
                  <h2>Become a premium user now!</h2>
                </div>
              </div>

              <div class="bullets">
                <span class="active" data-value="1"></span>
                <span data-value="2"></span>
                <span data-value="3"></span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <!-- Javascript file -->

    <script src="app.js"></script>
  </body>
</html>

 