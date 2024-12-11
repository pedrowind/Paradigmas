 // Função para salvar os heróis no localStorage
 function salvarHerois(herois) {
  localStorage.setItem("herois", JSON.stringify(herois));
}

// Função para recuperar os heróis armazenados no localStorage
function recuperarHerois() {
  const herois = localStorage.getItem("herois");
  return herois ? JSON.parse(herois) : [];
}

// Lidar com o envio do formulário
document.getElementById("formCriar").addEventListener("submit", function (event) {
  event.preventDefault();

  // Obter os dados do formulário
  const nome = document.getElementById("nomeCriar").value;
  const idade = parseInt(document.getElementById("idadeCriar").value);
  const sexo = document.querySelector('input[name="sexo"]:checked').value === "M" ? "Masculino" : "Feminino";
  const poderes = document.getElementById("poderesCriar").value.split(',').map(poder => poder.trim());
  const caracteristicasFisicas = document.getElementById("caracteristicas").value;
  const nivelForca = parseInt(document.getElementById("nivelForca").value);
  const popularidade = parseInt(document.getElementById("nivelPopularidade").value);
  const status = document.getElementById("dropdown").value === "1" ? "Ativo" : (document.getElementById("dropdown").value === "2" ? "Inativo" : "Banido");

  // Criar o herói
  const novoHeroi = {
    nome: nome,
    idade: idade,
    sexo: sexo,
    caracteristicasFisicas: caracteristicasFisicas,
    poderes: poderes,
    nivelForca: nivelForca,
    popularidade: popularidade,
    status: status,
    historicoBatalhas: []
  };

  // Recuperar os heróis atuais
  const herois = recuperarHerois();

  // Adicionar o novo herói
  herois.push(novoHeroi);

  // Salvar os heróis atualizados
  salvarHerois(herois);

  // Limpar o formulário
  document.getElementById("formCriar").reset();

  // Opcional: Exibir os heróis no console (para verificar)
  console.log(herois);
});

// Recuperar e exibir os heróis ao carregar a página
window.onload = function () {
  const herois = recuperarHerois();
  console.log("Heróis armazenados:", herois);
};



// const inputs = document.getElementsByClassName("inputNumber");

// for (const inputNumber of inputs) {
//     if (inputNumber.name === "idade") {
//         inputNumber.addEventListener("keypress", function (e) {
//             const typed = +e.key;
//             if (isNaN(typed) || typed < 0) {
//                 e.preventDefault();
//             }
//         });

//         inputNumber.addEventListener("blur", function () {
//             if (inputNumber.value < 18 && inputNumber.value !== "") {
//                 inputNumber.value = 18;
//             }
//         });
//         continue;
//     }

//     inputNumber.addEventListener("keypress", function (e) {
//         const typed = +e.key;
//         if (isNaN(typed) || typed < 0) {
//             e.preventDefault();
//         }
//         if (inputNumber.value >= 100) {
//             inputNumber.value = 100;
//             e.preventDefault();
//         }
//     });

//     inputNumber.addEventListener("blur", function () {
//         if (inputNumber.value === "") {
//             inputNumber.value = 50;
//         } else if (inputNumber.value > 100) {
//             inputNumber.value = 100;
//         }
//     });
// }