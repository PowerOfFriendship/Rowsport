<template>
    <button>
        <a class="nav-btn" id="logout" @click="logOut()">Log out</a>
    </button>
</template>

<script>
export default {
    methods: {
        logOut() {
            console.warn("logout");
            localStorage.clear();
            this.$router.push({ name: 'Register' });
        }
    }
}
</script>

<style>
#logout {
  margin-left: 50px;
  color: var(--offwhite)
}
</style>