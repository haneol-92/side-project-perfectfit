<template>
  <body>
  <div class="form-body">
    <div class="row">
      <div class="form-holder">
        <div class="form-content">
          <div class="form-items">
            <h3>회원가입</h3>
            <br>
            <b-form @submit="onSubmit" v-if="show" class="requires-validation" novalidate>
              <div class="col-md-12">
                <b-form-group
                    id="idset-1"
                    label="아이디"
                    label-for="input-id"
                    valid-feedback="사용가능합니다"
                    :invalid-feedback="invalidFeedback"
                    :state="state"
                >
                <b-form-input id="input-id" v-model="form.userid" :state="state" trim class="form-control" name="id" required></b-form-input>
                <button v-on:click="idCheck">id check</button>
                </b-form-group>
              </div>
              <br>
              <div class="col-md-12">
                <b-form-group id="pwset-1" label="비밀번호" label-for="input-pw">
                <b-form-input
                    id="input-pw"
                    v-model="form.passwd"
                    class="form-control"
                    type="password"
                    name="password"
                    required></b-form-input>
                </b-form-group>
              </div>
              <br>
              <div class="col-md-12">
                <b-form-group id="nameset-1" label="이름" label-for="input-name">
                <b-form-input
                    id="input-name"
                    v-model="form.name"
                    class="form-control"
                    type="text"
                    name="name"
                    required></b-form-input>
                </b-form-group>
              </div>
              <br>
              <div class="col-md-12">
                <b-form-group id="sexset-1" label="성별" label-for="input-sex">
                <b-form-select id="input-sex" v-model="form.sex" class="form-select mt-3" required>
                  <option selected disabled value="">성별</option>
                  <option value="m">남</option>
                  <option value="f">여</option>
                </b-form-select>
                </b-form-group>
              </div>
              <br>
              <div class="col-md-12">
                <b-form-group id="phoneset-1" label="휴대폰" label-for="input-phone"
                >
                <b-form-input
                    id="input-phone"
                    v-model="form.phone"
                    class="form-control"
                    type="phone"
                    name="phone"
                    required></b-form-input>
                </b-form-group>
              </div>
              <br>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                <label class="form-check-label">개인정보 수집에 동의합니다.</label>
              </div>


              <div class="form-button mt-3">
                <button id="submit" type="submit" class="btn btn-primary">확인</button>
              </div>
            </b-form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import axios from 'axios';
import router from "../router";
import VueCookies from "vue-cookies";

if(VueCookies.get('accessToken') != null){
  router.push({path:'./'})
}

export default {
  computed: {
    state() {
      return this.form.userid.length >= 5 && this.form.userid.length <= 12
    },
    invalidFeedback() {
      if (this.form.userid.length > 0) {
        return '5자 이상 12자 이하로 입력해주세요'
      }
      return 'id를 입력해주세요'
    }
  },
  data() {
    return {
      form: {
        userid: '',
        passwd: '',
        name: '',
        sex: '',
        phone: '',
        birth: '',
        createdAt: '',
        updatedAt: ''
      },
      show: true
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
      axios.post('http://localhost:9090/useradd',
          JSON.stringify(this.form), {headers: {'Content-Type': 'application/json'}}
      ).then(response => alert(response.data))
          .catch(e => console.log(e))
    },
    idCheck: function(data){
      data.preventDefault()
      axios.post('http://localhost:9090/idcheck',
        this.form.userid, {headers: {'Content-Type': 'text/plain'}}
      ).then(response => alert(response.data))
      .catch(e => console.log(e))
    }
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;900&display=swap');

*, body {
  font-family: 'Poppins', sans-serif;
  font-weight: 400;
  -webkit-font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
  -moz-osx-font-smoothing: grayscale;
}

html, body {
  height: 100%;
  background-image: linear-gradient(to right, #212529, #4f66ff);
  overflow: hidden;
}


.form-holder {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  min-height: 100vh;
}

.form-holder .form-content {
  position: relative;
  text-align: center;
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-align-items: center;
  align-items: center;
  padding: 60px;
}

.form-content .form-items {
  border: 3px solid #fff;
  padding: 40px;
  display: inline-block;
  width: 100%;
  min-width: 540px;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
  text-align: left;
  -webkit-transition: all 0.4s ease;
  transition: all 0.4s ease;
}

.form-content h3 {
  color: #fff;
  text-align: left;
  font-size: 28px;
  font-weight: 600;
  margin-bottom: 5px;
}

.form-content h3.form-title {
  margin-bottom: 30px;
}

.form-content p {
  color: #fff;
  text-align: left;
  font-size: 17px;
  font-weight: 300;
  line-height: 20px;
  margin-bottom: 30px;
}


.form-content label, .was-validated .form-check-input:invalid~.form-check-label, .was-validated .form-check-input:valid~.form-check-label{
  color: #fff;
}

.form-content input[type=text], .form-content input[type=password], .form-content input[type=email], .form-content select {
  width: 100%;
  padding: 9px 20px;
  text-align: left;
  border: 0;
  outline: 0;
  border-radius: 6px;
  background-color: #fff;
  font-size: 15px;
  font-weight: 300;
  color: #8D8D8D;
  -webkit-transition: all 0.3s ease;
  transition: all 0.3s ease;
  margin-top: 16px;
}


.btn-primary{
  background-color: #6C757D;
  outline: none;
  border: 0px;
  box-shadow: none;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active{
  background-color: #495056;
  outline: none !important;
  border: none !important;
  box-shadow: none;
}

.form-content textarea {
  position: static !important;
  width: 100%;
  padding: 8px 20px;
  border-radius: 6px;
  text-align: left;
  background-color: #fff;
  border: 0;
  font-size: 15px;
  font-weight: 300;
  color: #8D8D8D;
  outline: none;
  resize: none;
  height: 120px;
  -webkit-transition: none;
  transition: none;
  margin-bottom: 14px;
}

.form-content textarea:hover, .form-content textarea:focus {
  border: 0;
  background-color: #ebeff8;
  color: #8D8D8D;
}

.mv-up{
  margin-top: -9px !important;
  margin-bottom: 8px !important;
}

.invalid-feedback{
  color: #ff606e;
}

.valid-feedback{
  color: #2acc80;
}
</style>
