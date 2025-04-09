document.getElementById('form-consulta').addEventListener('submit', async function(event) {
    event.preventDefault();

    const endereco = document.getElementById('endereco').value;
    const data = document.getElementById('data').value;

    try {
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

        if (response.ok) {
            mensagem.innerHTML = "<p style='color: green;'>Consulta agendada com sucesso!</p>";
            document.getElementById('form-consulta').reset();
        } else {
            mensagem.innerHTML = "<p style='color: red;'>Erro ao agendar consulta.</p>";
        }

    } catch (error) {
        document.getElementById('mensagem').innerHTML = "<p style='color: red;'>Erro de rede: " + error.message + "</p>";
    }
});