document.getElementById('form-consulta').addEventListener('submit', async function(event) {
    event.preventDefault();

    const endereco = document.getElementById('endereco').value;
    const data = document.getElementById('data').value;



    
    try {                       //aqui abaixo vc tinha que ter colocado o localhost pra iniciar a conexão 

        const response = await fetch('/consultas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                endereco: endereco,
                data: data
            })
        });

        const mensagem = document.getElementById('mensagem');

        if (response.ok) { //aqui criar uma classe ao inves de colocar o css e o js tudo junto é uma pratica melhor 
                            // mas tb ficou muito bom a sua lógica do try catch             
            mensagem.innerHTML = "<p style='color: green;'>Consulta agendada com sucesso!</p>";
            document.getElementById('form-consulta').reset();
        } else {
            mensagem.innerHTML = "<p style='color: red;'>Erro ao agendar consulta.</p>";
        }

    } catch (error) {
        document.getElementById('mensagem').innerHTML = "<p style='color: red;'>Erro de rede: " + error.message + "</p>";
    }
});