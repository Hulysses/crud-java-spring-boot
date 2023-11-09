const formulario = document.querySelector('form');
const name = document.querySelector('.name');
const email = document.querySelector('.email');
const password = document.querySelector('.password');
const tel = document.querySelector('.tel');

document.addEventListener("DOMContentLoaded", function () {
    const telInput = document.querySelector(".tel");

    telInput.addEventListener("input", function () {
        this.value = this.value.replace(/\D/g, '');

        if (this.value.length > 11) {
            this.value = this.value.slice(0, 11);
        }
    });
});

function register() {

    if (name.value === '' || email.value === '' || password.value === '') {
        document.getElementById('empty-field-message').style.display = 'block';
        setTimeout(function () {
            document.getElementById('empty-field-message').style.display = 'none';
        }, 2000);
        return;
    }

    fetch('http://localhost:8080/users',
        {
            headers: {
                'Aceppt': "application/json",
                'Content-Type': "application/json"
            },
            method: 'POST',
            body: JSON.stringify({
                name: name.value,
                email: email.value,
                password: password.value,
                tel: tel.value
            })
        })
        .then(function (res) {
            if (res.status === 201) {
                document.getElementById('success-message').style.display = 'block';
                setTimeout(function () {
                    document.getElementById('success-message').style.display = 'none';
                }, 2000);
            } else if (res.status === 500) {
                document.getElementById('email-error-message').style.display = 'block';
                setTimeout(function () {
                    document.getElementById('email-error-message').style.display = 'none';
                }, 2000);
            }
        })
        .catch(function (res) { console.log(res) })
}

function clean() {

    name.value = "";
    email.value = "";
    password.value = "";
    tel.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    register();
    clean();
});