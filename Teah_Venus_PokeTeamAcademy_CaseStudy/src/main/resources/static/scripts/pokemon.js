
const apiURL = 'https://pokeapi.co/api/v2/pokemon?limit=151';




/**RETREIVE POKEMON FROM DATBASE)**/

async function getPokemonData() {
    try {
        const response = await fetch(apiURL);
        const data = await response.json();
        return data.results;

    } catch (error) {
        console.log(error);
    }
}

getPokemonData().then((data) => console.log(data));

const row = document.querySelector('.row');


function createCard(pokemon) {
    //CREATE CARD CONTAINER ELEMENT FOR CARD
    const card = document.createElement('div');
    card.classList.add('card', pokemon.types[0].type.name);

    //CREATE NAME TEXT ELEMENT FOR CARD
    const name = document.createElement('h2');
    name.textContent = pokemon.name;

    //CREATE NUMBER TEXT ELEMENT FOR CARD
    const number = document.createElement('p');
    number.textContent = `#${pokemon.id.toString().padStart(3, '0')}`;

    //CREATE IMAGE ELEMENT FOR CARD
    const image = document.createElement('img');
    image.src = pokemon.sprites.front_default;
    image.alt = pokemon.name;

    //CREATE MODAL BUTTON FOR CARD
    let modalbtn = document.createElement('button')
    modalbtn.id = "modalbtn";
    modalbtn.innerText = "Choose Me"

    //CREATE MODAL DIV FOR CARD
    let modalBody = document.createElement('div')
    modalBody.id = "modalBody";
    modalBody.class = "modalBody";
    modalBody.innerHTML =
        '<div class="modal-content"> ' +
    '<span class="close">&times;</span> ' +
    '<p>Choose this Pokemon..</p> ' +
    '</div>'

    const postURL=`/pokemon/${pokemon.name}/${pokemon.id}`;
//MODAL FUNCTIONALITY

// OPEN MODAL WHEN CLICKED
    modalbtn.onclick = () => {

        window.location.assign(postURL)

    };


// CLOSE MODAL WHEN 'X' IS CLICKED
    let span = document.getElementsByClassName("close");
    span.onclick = () => {
        modalBody.style.display = "none"
        console.log("x is clicked")
    };

// CLOSE MODAL WHEN USER CLICKS ELSEWHERE ON SCREEN
    window.onclick = (event) => {
        if (event.target == modalBody)
            modalBody.style.display = "none"
    };


    card.append(name, number, image, modalbtn);
    return card;
}

/**DISPLAY POKEMON)**/
async function displayPokemonData() {
    const pokemonData = await getPokemonData();
    const pokemonPromises = pokemonData.map(async (pokemon) => {


        const response = await fetch(pokemon.url);
        return response.json();
    });
    const pokemonList = await Promise.all(pokemonPromises);
    pokemonList.forEach((pokemon) => {
        const card = createCard(pokemon);
        row.append(card);
    });
}


displayPokemonData();




