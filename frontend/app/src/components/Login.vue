<template>
  <body>
  <div class="container px-4 py-5 mx-auto">
    <div class="card card0">
      <div class="d-flex flex-lg-row flex-column-reverse">
        <div class="card card1">
          <div class="row justify-content-center my-auto">
            <div class="col-md-8 col-10 my-5">
              <div class="row justify-content-center px-3 mb-3"> <img id="logo" src="https://i.imgur.com/PSXxjNY.png"> </div>
              <h3 class="mb-5 text-center heading">Sports Score Board</h3>
              <h6 class="msg-info">Please login to your account</h6>
              <b-form @submit="onSubmit">
                <b-form-group class="form-control-label text-muted" id="input-group-1" label="Username" label-for="input-1">
                  <b-form-input class="form-control" id="input-1" v-model="form.userid" placeholder="Enter Username" required></b-form-input>
                </b-form-group>
                <b-form-group class="form-control-label text-muted" id="input-group-2" label="Password" label-for="input-2">
                  <b-form-input class="form-control" id="input-2" v-model="form.passwd" type="password" placeholder="Enter Password" required></b-form-input>
                </b-form-group>
                <div class="row justify-content-center my-3 px-3"> <b-button class="btn-block btn-color" type="submit">Login</b-button></div>
                <div class="row justify-content-center my-2"> <a href="#"><small class="text-muted">Forgot Password?</small></a> </div>
              </b-form>
            </div>
          </div>
          <div class="bottom text-center mb-5">
            <p href="#" class="sm-text mx-auto mb-3">Don't have an account?<button @click="register" class="btn btn-white ml-2">Create new</button></p>
          </div>
        </div>
        <div class="card card2">
          <div class="my-auto mx-md-5 px-md-5 right">
            <h3 class="text-white">We are more than just a company</h3> <small class="text-white">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</small>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import axios from 'axios';
import VueCookies from "vue-cookies";
import router from "../router";

const storage = window.sessionStorage;

if(VueCookies.get('accessToken') != null){
  router.push({path:'./'})
}

export default {
  data() {
    return {
      form: {
        userid: '',
        passwd: '',
        token: "",
      }
    }
  },
  methods: {
    onSubmit(event) {
      storage.setItem("jwt-auth-token", "")
      storage.setItem("login_user", "")
      event.preventDefault()
      axios.post('http://localhost:9090/login',
          JSON.stringify(this.form), { headers: { 'Content-Type': 'application/json' }}
      ).then(response => {
        if (response.data.status){
          axios.defaults.headers.common["X-XSRF-TOKEN"] = response.data.token
          storage.setItem("jwt-auth-token", response.data.token)
          storage.setItem("login_user",response.data.data.userid)
          this.$cookies.set('accessToken', response.data.token, 60*30)
          this.$router.push({path:'./'})
        }else {
          alert("로그인 정보 확인해주세요")
        }
      }).catch(()=> alert("로그인 실패!"))
    },
    register(){
      this.$router.push({path:'./register'})
    }
  }
}
</script>

<style scoped>
body {
  color: #000;
  overflow-x: hidden;
  height: 100%;
  background-image: linear-gradient(to right, #212529, #4f66ff);
  background-repeat: no-repeat
}

input,
textarea {
  background-color: #e5f4f5;
  border-radius: 50px !important;
  padding: 12px 15px 12px 15px !important;
  width: 100%;
  box-sizing: border-box;
  border: none !important;
  border: 1px solid #e5f4f5 !important;
  font-size: 16px !important;
  color: #000 !important;
  font-weight: 400
}

input:focus,
textarea:focus {
  -moz-box-shadow: none !important;
  -webkit-box-shadow: none !important;
  box-shadow: none !important;
  border: 1px solid #0070f9 !important;
  outline-width: 0;
  font-weight: 400
}

button:focus {
  -moz-box-shadow: none !important;
  -webkit-box-shadow: none !important;
  box-shadow: none !important;
  outline-width: 0
}

.card {
  border-radius: 0;
  border: none
}

.card1 {
  width: 50%;
  padding: 40px 30px 10px 30px
}

.card2 {
  width: 50%;
  background-image: linear-gradient(to right, #212529, #0004f9)
}

#logo {
  width: 70px;
  height: 60px
}

.heading {
  margin-bottom: 60px !important
}

::placeholder {
  color: #000 !important;
  opacity: 1
}

:-ms-input-placeholder {
  color: #000 !important
}

::-ms-input-placeholder {
  color: #000 !important
}

.form-control-label {
  font-size: 12px;
  margin-left: 15px
}

.msg-info {
  padding-left: 15px;
  margin-bottom: 30px
}

.btn-color {
  border-radius: 50px;
  color: #fff;
  background-image: linear-gradient(to right, #4fb3ff, #0047f9);
  padding: 15px;
  cursor: pointer;
  border: none !important;
  margin-top: 40px
}

.btn-color:hover {
  color: #fff;
  background-image: linear-gradient(to right, #00b2f9, #4f90ff)
}

.btn-white {
  border-radius: 50px;
  color: #0047f9;
  background-color: #fff;
  padding: 8px 40px;
  cursor: pointer;
  border: 2px solid #0047f9 !important
}

.btn-white:hover {
  color: #fff;
  background-image: linear-gradient(to right, #4fadff, #000cf9)
}

a {
  color: #000
}

a:hover {
  color: #000
}

.bottom {
  width: 100%;
  margin-top: 50px !important
}

.sm-text {
  font-size: 15px
}

@media screen and (max-width: 992px) {
  .card1 {
    width: 100%;
    padding: 40px 30px 10px 30px
  }

  .card2 {
    width: 100%
  }

  .right {
    margin-top: 100px !important;
    margin-bottom: 100px !important
  }
}

@media screen and (max-width: 768px) {
  .container {
    padding: 10px !important
  }

  .card2 {
    padding: 50px
  }

  .right {
    margin-top: 50px !important;
    margin-bottom: 50px !important
  }
}
</style>
