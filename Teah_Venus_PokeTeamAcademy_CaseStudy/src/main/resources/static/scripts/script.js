const topBox = document.querySelector(".one");
const middleBox = document.querySelector(".two");
const bottomBox = document.querySelector(".three");

// function team(trainerChoice) {
//     console.log(trainerChoice);
// }
// topBox.addEventListener('click', function () {
//     // console.log("One was clicked");
//     team("one");
// })
//
// middleBox.addEventListener('click', function () {
//     // console.log("Two was clicked");
//     team("two");
// })
//
// bottomBox.addEventListener('click', function () {
//     // console.log("Three was clicked");
//     team("three");
//
// })

//
//
//
//
//
const PokemonAllThreeTypes = async id => {

    const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
    const pokemonObj = await response.json();

    if (pokemonObj.types[0].type.name === "grass" ||
        pokemonObj.types[0].type.name === "fire" ||
        pokemonObj.types[0].type.name === "water") {

        console.log(pokemonObj);

        // createPokemonCard(pokemonObj);
    }
};





const getAllPokemon = async () => {


    for (let i = 1; i <= 151; i++) {
        const poke = await PokemonAllThreeTypes(i);
    }
};


getAllPokemon();

