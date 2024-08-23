document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('form-servidor').addEventListener('submit', function(event) {
        event.preventDefault();

        const servidor = {
            siepe: document.getElementById('siepe').value,
            cargo: document.getElementById('cargo').value,
            nome: document.getElementById('nome').value,
            CPF: document.getElementById('cpf').value,
            RG: document.getElementById('rg').value,
            dataNascimento: document.getElementById('dataNascimento').value,
            telefone: document.getElementById('telefone').value,
            email: document.getElementById('email').value,

            estado: document.getElementById('estado').value,
            cidade: document.getElementById('cidade').value,
            cep: document.getElementById('cep').value,
            bairro: document.getElementById('bairro').value,
            rua: document.getElementById('rua').value,
            numero: document.getElementById('numero').value,
            complemento: document.getElementById('complemento').value,

            nomeBanco: document.getElementById('nomeBanco').value,
            numConta: document.getElementById('numConta').value,
            agencia: document.getElementById('agencia').value,
            operacao: document.getElementById('operacao').value
                     };

        fetch('http://localhost:8080/servidor', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(servidor)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar servidor: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            alert('Servidor cadastrado com sucesso!');
            console.log('Success:', data);
        })
        .catch(error => {
            console.error('Erro ao cadastrar servidor:', error);
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('form-alunos').addEventListener('submit', function(event) {
        event.preventDefault();

        const alunos = {
            
            nome: document.getElementById('nome').value,
            CPF: document.getElementById('cpf').value,
            RG: document.getElementById('rg').value,
            dataNascimento: document.getElementById('dataNascimento').value,
            telefone: document.getElementById('telefone').value,
            email: document.getElementById('email').value,
            
            estado: document.getElementById('estado').value,
            cidade: document.getElementById('cidade').value,
            cep: document.getElementById('cep').value,
            bairro: document.getElementById('bairro').value,
            rua: document.getElementById('rua').value,
            numero: document.getElementById('numero').value,
            complemento: document.getElementById('complemento').value,

            nomeBanco: document.getElementById('nomeBanco').value,
            numConta: document.getElementById('numConta').value,
            agencia: document.getElementById('agencia').value,
            operacao: document.getElementById('operacao').value
                     };

        fetch('http://localhost:8080/alunos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(alunos)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar alunos: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            alert('alunos cadastrado com sucesso!');
            console.log('Success:', data);
        })
        .catch(error => {
            console.error('Erro ao cadastrar alunos:', error);
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
    // Adiciona o evento ao botão para buscar alunos
    document.getElementById('btn-fetch-alunos').addEventListener('click', function() {
        fetchAlunos();
    });

    // Função para buscar e exibir os alunos
    function fetchAlunos() {
        fetch('http://localhost:8080/alunos')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Erro ao buscar alunos: ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                console.log('Aluno:', data);
                displayAlunos(data);
            })
            .catch(error => {
                console.error('Erro ao buscar alunos:', error);
            });
    }

    // Função para exibir alunos na página
    function displayAlunos(alunos) {
        const alunoList = document.getElementById('aluno-list');
        alunoList.innerHTML = '';

        alunos.forEach(aluno => {
            const listItem = document.createElement('li');
            listItem.textContent = `Nome: ${aluno.nome}, CPF: ${aluno.cpf}, RG: ${aluno.RG}, Data de Nascimento: ${aluno.dataNascimento}, Telefone: ${aluno.telefone}, Email: ${aluno.email}`;
            alunoList.appendChild(listItem);
        });
    }
});