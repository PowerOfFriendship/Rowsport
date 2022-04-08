<template>
  <div class="main-container">
        <div>
            <input 
                type="username" 
                placeholder="uživatelské jméno"  
                v-model="this.username" 
                class="input"
                :class="{ red:emptyUsername }"
                />
        </div>
        <div>
            <input 
                type="name" 
                placeholder="jméno"  
                v-model="this.name" 
                class="input"
                :class="{ red:emptyName }"
                />
        </div>
        <div>
            <input 
                type="text" 
                placeholder="příjmení"  
                v-model="this.surname" 
                class="input"
                :class="{ red:emptySurname }"
                />
        </div>
        <div>
            <input 
                type="tel" 
                placeholder="telefon"  
                v-model="this.telephone" 
                class="input"
                :class="{ red:emptyName }"
                />
        </div>
        <div>
            <input 
                type="email" 
                placeholder="email@server.com" 
                @blur="handleEmptyBlurEmail(this.email)" 
                @focus="(this.emptyEmail = false), (this.emailWrongFormat = false)" 
                v-model="this.email" 
                class="input"
                :class="{ red:emptyEmail }"
                />
        </div>
        <div>
            <input
                class="input"
                type="password"
                placeholder="password"
                @blur="handleEmptyBlurPassword(this.password)"
                @focus="(this.emptyPassword = false), (this.passwordShort = false)"
                v-model="this.password"
                :class="{ red: emptyPassword }"
            />
        </div>
        <div>
            <input
                class="input"
                type="password"
                placeholder="confirm password"
                @blur="handleEmptyBlurPassword(this.passwordConfirmation)"
                @focus="(this.emptyPassword = false), (this.passwordShort = false)"
                v-model="this.password"
                :class="{ red: emptyPassword }"
            />
        </div>
        <button id="reg-btn" class="wild-button" @click="validateSubmit()">Register</button>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.input-f {
  align-items: center;
  align-content: center;
  margin-bottom: 5px;
}
#reg-btn {
  font-family: "Roboto Mono", monospace;
  font-size: 18px;
  border: none;
  height: 38px;
  width: 215px;
  padding: 6px;
  border-radius: 3px;
  color: beige;
  background-color: #5f5f5f;
  margin-top: 10px;
}
.input {
  font-family: "Roboto Mono", monospace;
  border: 1px solid black;
  border-radius: 0 3px 3px 0;
  border-left: 0;
  height: 26px;
  padding: 5px;
  padding-left: 10px;
  margin-bottom: 5px;
}
.input:focus {
  outline: none;
  background: #cecece;
}
.input::placeholder {
  color: #5f5f5f;
}
</style>