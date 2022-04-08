<template>
    <header>
        <h1>This is navbar of Rowspor</h1>
        <nav>
            <router-link :to="{ name: 'Calendar' }">Home</router-link>
            <router-link :to="{ name: 'AccountDetail'}">Account Detail</router-link>
        </nav>
        <Logout />
    </header>
</template>

<script>
import Logout from './Logout.vue'

export default {
    components: { Logout }
}
</script>

<style>
    header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        max-width: 1200px;
        margin: 0 auto;
        padding: 10px;
    }
    header h1 {
        color: #dfdfdf;
        font-size: 48px;
    }
    header a {
        color: #bbb;
        text-decoration: none;
        margin-left: 20px;
    }
    header a.router-link-active {
        color: #444;
        font-weight: bold;
    }
</style>