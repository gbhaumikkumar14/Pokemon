package com.bhaumikghodasara.data.mocks

object MockApiResponses {
    val pokemonList = """{
"count": 1281,
"next": "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
"previous": null,
"results": [
{
"name": "bulbasaur",
"url": "https://pokeapi.co/api/v2/pokemon/1/"
},
{
"name": "ivysaur",
"url": "https://pokeapi.co/api/v2/pokemon/2/"
},
{
"name": "venusaur",
"url": "https://pokeapi.co/api/v2/pokemon/3/"
},
{
"name": "charmander",
"url": "https://pokeapi.co/api/v2/pokemon/4/"
},
{
"name": "charmeleon",
"url": "https://pokeapi.co/api/v2/pokemon/5/"
},
{
"name": "charizard",
"url": "https://pokeapi.co/api/v2/pokemon/6/"
},
{
"name": "squirtle",
"url": "https://pokeapi.co/api/v2/pokemon/7/"
},
{
"name": "wartortle",
"url": "https://pokeapi.co/api/v2/pokemon/8/"
},
{
"name": "blastoise",
"url": "https://pokeapi.co/api/v2/pokemon/9/"
},
{
"name": "caterpie",
"url": "https://pokeapi.co/api/v2/pokemon/10/"
},
{
"name": "metapod",
"url": "https://pokeapi.co/api/v2/pokemon/11/"
},
{
"name": "butterfree",
"url": "https://pokeapi.co/api/v2/pokemon/12/"
},
{
"name": "weedle",
"url": "https://pokeapi.co/api/v2/pokemon/13/"
},
{
"name": "kakuna",
"url": "https://pokeapi.co/api/v2/pokemon/14/"
},
{
"name": "beedrill",
"url": "https://pokeapi.co/api/v2/pokemon/15/"
},
{
"name": "pidgey",
"url": "https://pokeapi.co/api/v2/pokemon/16/"
},
{
"name": "pidgeotto",
"url": "https://pokeapi.co/api/v2/pokemon/17/"
},
{
"name": "pidgeot",
"url": "https://pokeapi.co/api/v2/pokemon/18/"
},
{
"name": "rattata",
"url": "https://pokeapi.co/api/v2/pokemon/19/"
},
{
"name": "raticate",
"url": "https://pokeapi.co/api/v2/pokemon/20/"
}
]
}"""

    val pokemonDetails = """{
  "abilities": [
    {
      "ability": {
        "name": "blaze",
        "url": "https://pokeapi.co/api/v2/ability/66/"
      },
      "is_hidden": false,
      "slot": 1
    },
    {
      "ability": {
        "name": "solar-power",
        "url": "https://pokeapi.co/api/v2/ability/94/"
      },
      "is_hidden": true,
      "slot": 3
    }
  ],
  "base_experience": 267,
  "forms": [],
  "game_indices": [
    {
      "game_index": 180,
      "version": {
        "name": "red",
        "url": "https://pokeapi.co/api/v2/version/1/"
      }
    },
    {
      "game_index": 180,
      "version": {
        "name": "blue",
        "url": "https://pokeapi.co/api/v2/version/2/"
      }
    },
    {
      "game_index": 180,
      "version": {
        "name": "yellow",
        "url": "https://pokeapi.co/api/v2/version/3/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "gold",
        "url": "https://pokeapi.co/api/v2/version/4/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "silver",
        "url": "https://pokeapi.co/api/v2/version/5/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "crystal",
        "url": "https://pokeapi.co/api/v2/version/6/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "ruby",
        "url": "https://pokeapi.co/api/v2/version/7/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "sapphire",
        "url": "https://pokeapi.co/api/v2/version/8/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "emerald",
        "url": "https://pokeapi.co/api/v2/version/9/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "firered",
        "url": "https://pokeapi.co/api/v2/version/10/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "leafgreen",
        "url": "https://pokeapi.co/api/v2/version/11/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "diamond",
        "url": "https://pokeapi.co/api/v2/version/12/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "pearl",
        "url": "https://pokeapi.co/api/v2/version/13/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "platinum",
        "url": "https://pokeapi.co/api/v2/version/14/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "heartgold",
        "url": "https://pokeapi.co/api/v2/version/15/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "soulsilver",
        "url": "https://pokeapi.co/api/v2/version/16/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "black",
        "url": "https://pokeapi.co/api/v2/version/17/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "white",
        "url": "https://pokeapi.co/api/v2/version/18/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "black-2",
        "url": "https://pokeapi.co/api/v2/version/21/"
      }
    },
    {
      "game_index": 6,
      "version": {
        "name": "white-2",
        "url": "https://pokeapi.co/api/v2/version/22/"
      }
    }
  ],
  "height": 17,
  "held_items": [],
  "id": 6,
  "is_default": true,
  "location_area_encounters": "https://pokeapi.co/api/v2/pokemon/6/encounters",
  "moves": [
    {
      "move": {
        "name": "mega-punch",
        "url": "https://pokeapi.co/api/v2/move/5/"
      },
      "version_group_details": [
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "red-blue",
            "url": "https://pokeapi.co/api/v2/version-group/1/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "yellow",
            "url": "https://pokeapi.co/api/v2/version-group/2/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "emerald",
            "url": "https://pokeapi.co/api/v2/version-group/6/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "firered-leafgreen",
            "url": "https://pokeapi.co/api/v2/version-group/7/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "sword-shield",
            "url": "https://pokeapi.co/api/v2/version-group/20/"
          }
        }
      ]
    },
    {
      "move": {
        "name": "fire-punch",
        "url": "https://pokeapi.co/api/v2/move/7/"
      },
      "version_group_details": [
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "gold-silver",
            "url": "https://pokeapi.co/api/v2/version-group/3/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "crystal",
            "url": "https://pokeapi.co/api/v2/version-group/4/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "emerald",
            "url": "https://pokeapi.co/api/v2/version-group/6/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "platinum",
            "url": "https://pokeapi.co/api/v2/version-group/9/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "heartgold-soulsilver",
            "url": "https://pokeapi.co/api/v2/version-group/10/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "black-2-white-2",
            "url": "https://pokeapi.co/api/v2/version-group/14/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "omega-ruby-alpha-sapphire",
            "url": "https://pokeapi.co/api/v2/version-group/16/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "tutor",
            "url": "https://pokeapi.co/api/v2/move-learn-method/3/"
          },
          "version_group": {
            "name": "ultra-sun-ultra-moon",
            "url": "https://pokeapi.co/api/v2/version-group/18/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "lets-go-pikachu-lets-go-eevee",
            "url": "https://pokeapi.co/api/v2/version-group/19/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "sword-shield",
            "url": "https://pokeapi.co/api/v2/version-group/20/"
          }
        },
        {
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
          "version_group": {
            "name": "scarlet-violet",
            "url": "https://pokeapi.co/api/v2/version-group/25/"
          }
        }
      ]
    }
  ],
  "name": "charizard",
  "order": 7,
  "past_types": [],
  "species": {
    "name": "charizard",
    "url": "https://pokeapi.co/api/v2/pokemon-species/6/"
  },
  "sprites": {
    "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/6.png",
    "back_female": null,
    "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/6.png",
    "back_shiny_female": null,
    "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
    "front_female": null,
    "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/6.png",
    "front_shiny_female": null,
    "other": {
      "dream_world": {
        "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/6.svg",
        "front_female": null
      },
      "home": {
        "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/6.png",
        "front_female": null,
        "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/shiny/6.png",
        "front_shiny_female": null
      },
      "official-artwork": {
        "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png",
        "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/6.png"
      }
    },
    "versions": {
      "generation-i": {
        "red-blue": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/back/6.png",
          "back_gray": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/back/gray/6.png",
          "back_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/transparent/back/6.png",
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/6.png",
          "front_gray": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/gray/6.png",
          "front_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/transparent/6.png"
        },
        "yellow": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/back/6.png",
          "back_gray": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/back/gray/6.png",
          "back_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/transparent/back/6.png",
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/6.png",
          "front_gray": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/gray/6.png",
          "front_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/transparent/6.png"
        }
      },
      "generation-ii": {
        "crystal": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/6.png",
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/shiny/6.png",
          "back_shiny_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/shiny/6.png",
          "back_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/6.png",
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/6.png",
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/shiny/6.png",
          "front_shiny_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/shiny/6.png",
          "front_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/6.png"
        },
        "gold": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/back/6.png",
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/back/shiny/6.png",
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/6.png",
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/shiny/6.png",
          "front_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/transparent/6.png"
        },
        "silver": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/back/6.png",
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/back/shiny/6.png",
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/6.png",
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/shiny/6.png",
          "front_transparent": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/transparent/6.png"
        }
      },
      "generation-iii": {
        "emerald": {
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/emerald/6.png",
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/emerald/shiny/6.png"
        },
        "firered-leafgreen": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/back/6.png",
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/back/shiny/6.png",
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/6.png",
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/shiny/6.png"
        },
        "ruby-sapphire": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/back/6.png",
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/back/shiny/6.png",
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/6.png",
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/shiny/6.png"
        }
      },
      "generation-iv": {
        "diamond-pearl": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/back/6.png",
          "back_female": null,
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/back/shiny/6.png",
          "back_shiny_female": null,
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/6.png",
          "front_female": null,
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/shiny/6.png",
          "front_shiny_female": null
        },
        "heartgold-soulsilver": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/back/6.png",
          "back_female": null,
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/back/shiny/6.png",
          "back_shiny_female": null,
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/6.png",
          "front_female": null,
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/shiny/6.png",
          "front_shiny_female": null
        },
        "platinum": {
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/6.png",
          "back_female": null,
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/shiny/6.png",
          "back_shiny_female": null,
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/6.png",
          "front_female": null,
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/shiny/6.png",
          "front_shiny_female": null
        }
      },
      "generation-v": {
        "black-white": {
          "animated": {
            "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/6.gif",
            "back_female": null,
            "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/shiny/6.gif",
            "back_shiny_female": null,
            "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/6.gif",
            "front_female": null,
            "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/shiny/6.gif",
            "front_shiny_female": null
          },
          "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/6.png",
          "back_female": null,
          "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/shiny/6.png",
          "back_shiny_female": null,
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/6.png",
          "front_female": null,
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/shiny/6.png",
          "front_shiny_female": null
        }
      },
      "generation-vi": {
        "omegaruby-alphasapphire": {
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/6.png",
          "front_female": null,
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/shiny/6.png",
          "front_shiny_female": null
        },
        "x-y": {
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/6.png",
          "front_female": null,
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/shiny/6.png",
          "front_shiny_female": null
        }
      },
      "generation-vii": {
        "icons": {
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/icons/6.png",
          "front_female": null
        },
        "ultra-sun-ultra-moon": {
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/ultra-sun-ultra-moon/6.png",
          "front_female": null,
          "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/ultra-sun-ultra-moon/shiny/6.png",
          "front_shiny_female": null
        }
      },
      "generation-viii": {
        "icons": {
          "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/6.png",
          "front_female": null
        }
      }
    }
  },
  "stats": [
    {
      "base_stat": 78,
      "effort": 0,
      "stat": {
        "name": "hp",
        "url": "https://pokeapi.co/api/v2/stat/1/"
      }
    },
    {
      "base_stat": 84,
      "effort": 0,
      "stat": {
        "name": "attack",
        "url": "https://pokeapi.co/api/v2/stat/2/"
      }
    },
    {
      "base_stat": 78,
      "effort": 0,
      "stat": {
        "name": "defense",
        "url": "https://pokeapi.co/api/v2/stat/3/"
      }
    },
    {
      "base_stat": 109,
      "effort": 3,
      "stat": {
        "name": "special-attack",
        "url": "https://pokeapi.co/api/v2/stat/4/"
      }
    },
    {
      "base_stat": 85,
      "effort": 0,
      "stat": {
        "name": "special-defense",
        "url": "https://pokeapi.co/api/v2/stat/5/"
      }
    },
    {
      "base_stat": 100,
      "effort": 0,
      "stat": {
        "name": "speed",
        "url": "https://pokeapi.co/api/v2/stat/6/"
      }
    }
  ],
  "types": [
    {
      "slot": 1,
      "type": {
        "name": "fire",
        "url": "https://pokeapi.co/api/v2/type/10/"
      }
    },
    {
      "slot": 2,
      "type": {
        "name": "flying",
        "url": "https://pokeapi.co/api/v2/type/3/"
      }
    }
  ],
  "weight": 905
}"""

    val pokemonAdditionalDetails = """{
  "base_happiness": 50,
  "capture_rate": 45,
  "color": {
    "name": "red",
    "url": "https://pokeapi.co/api/v2/pokemon-color/8/"
  },
  "egg_groups": [
    {
      "name": "monster",
      "url": "https://pokeapi.co/api/v2/egg-group/1/"
    },
    {
      "name": "dragon",
      "url": "https://pokeapi.co/api/v2/egg-group/14/"
    }
  ],
  "evolution_chain": {
    "url": "https://pokeapi.co/api/v2/evolution-chain/2/"
  },
  "evolves_from_species": {
    "name": "charmeleon",
    "url": "https://pokeapi.co/api/v2/pokemon-species/5/"
  },
  "flavor_text_entries": [
    {
      "flavor_text": "Spits fire that\nis hot enough to\nmelt boulders.\fKnown to cause\nforest fires\nunintentionally.",
      "language": {
        "name": "en",
        "url": "https://pokeapi.co/api/v2/language/9/"
      },
      "version": {
        "name": "red",
        "url": "https://pokeapi.co/api/v2/version/1/"
      }
    },
    {
      "flavor_text": "Spits fire that\nis hot enough to\nmelt boulders.\fKnown to cause\nforest fires\nunintentionally.",
      "language": {
        "name": "en",
        "url": "https://pokeapi.co/api/v2/language/9/"
      },
      "version": {
        "name": "blue",
        "url": "https://pokeapi.co/api/v2/version/2/"
      }
    }
  ],
  "form_descriptions": [],
  "forms_switchable": true,
  "gender_rate": 1,
  "genera": [
    {
      "genus": "かえんポケモン",
      "language": {
        "name": "ja-Hrkt",
        "url": "https://pokeapi.co/api/v2/language/1/"
      }
    },
    {
      "genus": "화염포켓몬",
      "language": {
        "name": "ko",
        "url": "https://pokeapi.co/api/v2/language/3/"
      }
    },
    {
      "genus": "火焰寶可夢",
      "language": {
        "name": "zh-Hant",
        "url": "https://pokeapi.co/api/v2/language/4/"
      }
    },
    {
      "genus": "Pokémon Flamme",
      "language": {
        "name": "fr",
        "url": "https://pokeapi.co/api/v2/language/5/"
      }
    },
    {
      "genus": "Flammen-Pokémon",
      "language": {
        "name": "de",
        "url": "https://pokeapi.co/api/v2/language/6/"
      }
    },
    {
      "genus": "Pokémon Llama",
      "language": {
        "name": "es",
        "url": "https://pokeapi.co/api/v2/language/7/"
      }
    },
    {
      "genus": "Pokémon Fiamma",
      "language": {
        "name": "it",
        "url": "https://pokeapi.co/api/v2/language/8/"
      }
    },
    {
      "genus": "Flame Pokémon",
      "language": {
        "name": "en",
        "url": "https://pokeapi.co/api/v2/language/9/"
      }
    },
    {
      "genus": "かえんポケモン",
      "language": {
        "name": "ja",
        "url": "https://pokeapi.co/api/v2/language/11/"
      }
    },
    {
      "genus": "火焰宝可梦",
      "language": {
        "name": "zh-Hans",
        "url": "https://pokeapi.co/api/v2/language/12/"
      }
    }
  ],
  "generation": {
    "name": "generation-i",
    "url": "https://pokeapi.co/api/v2/generation/1/"
  },
  "growth_rate": {
    "name": "medium-slow",
    "url": "https://pokeapi.co/api/v2/growth-rate/4/"
  },
  "habitat": {
    "name": "mountain",
    "url": "https://pokeapi.co/api/v2/pokemon-habitat/4/"
  },
  "has_gender_differences": false,
  "hatch_counter": 20,
  "id": 6,
  "is_baby": false,
  "is_legendary": false,
  "is_mythical": false,
  "name": "charizard",
  "names": [
    {
      "language": {
        "name": "ja-Hrkt",
        "url": "https://pokeapi.co/api/v2/language/1/"
      },
      "name": "リザードン"
    },
    {
      "language": {
        "name": "roomaji",
        "url": "https://pokeapi.co/api/v2/language/2/"
      },
      "name": "Lizardon"
    },
    {
      "language": {
        "name": "ko",
        "url": "https://pokeapi.co/api/v2/language/3/"
      },
      "name": "리자몽"
    },
    {
      "language": {
        "name": "zh-Hant",
        "url": "https://pokeapi.co/api/v2/language/4/"
      },
      "name": "噴火龍"
    },
    {
      "language": {
        "name": "fr",
        "url": "https://pokeapi.co/api/v2/language/5/"
      },
      "name": "Dracaufeu"
    },
    {
      "language": {
        "name": "de",
        "url": "https://pokeapi.co/api/v2/language/6/"
      },
      "name": "Glurak"
    },
    {
      "language": {
        "name": "es",
        "url": "https://pokeapi.co/api/v2/language/7/"
      },
      "name": "Charizard"
    },
    {
      "language": {
        "name": "it",
        "url": "https://pokeapi.co/api/v2/language/8/"
      },
      "name": "Charizard"
    },
    {
      "language": {
        "name": "en",
        "url": "https://pokeapi.co/api/v2/language/9/"
      },
      "name": "Charizard"
    },
    {
      "language": {
        "name": "ja",
        "url": "https://pokeapi.co/api/v2/language/11/"
      },
      "name": "リザードン"
    },
    {
      "language": {
        "name": "zh-Hans",
        "url": "https://pokeapi.co/api/v2/language/12/"
      },
      "name": "喷火龙"
    }
  ],
  "order": 6,
  "pal_park_encounters": [
    {
      "area": {
        "name": "field",
        "url": "https://pokeapi.co/api/v2/pal-park-area/2/"
      },
      "base_score": 90,
      "rate": 3
    }
  ],
  "pokedex_numbers": [
    {
      "entry_number": 6,
      "pokedex": {
        "name": "national",
        "url": "https://pokeapi.co/api/v2/pokedex/1/"
      }
    },
    {
      "entry_number": 6,
      "pokedex": {
        "name": "kanto",
        "url": "https://pokeapi.co/api/v2/pokedex/2/"
      }
    },
    {
      "entry_number": 231,
      "pokedex": {
        "name": "original-johto",
        "url": "https://pokeapi.co/api/v2/pokedex/3/"
      }
    },
    {
      "entry_number": 236,
      "pokedex": {
        "name": "updated-johto",
        "url": "https://pokeapi.co/api/v2/pokedex/7/"
      }
    },
    {
      "entry_number": 111,
      "pokedex": {
        "name": "conquest-gallery",
        "url": "https://pokeapi.co/api/v2/pokedex/11/"
      }
    },
    {
      "entry_number": 85,
      "pokedex": {
        "name": "kalos-central",
        "url": "https://pokeapi.co/api/v2/pokedex/12/"
      }
    },
    {
      "entry_number": 6,
      "pokedex": {
        "name": "letsgo-kanto",
        "url": "https://pokeapi.co/api/v2/pokedex/26/"
      }
    },
    {
      "entry_number": 380,
      "pokedex": {
        "name": "galar",
        "url": "https://pokeapi.co/api/v2/pokedex/27/"
      }
    }
  ],
  "shape": {
    "name": "upright",
    "url": "https://pokeapi.co/api/v2/pokemon-shape/6/"
  },
  "varieties": [
    {
      "is_default": true,
      "pokemon": {
        "name": "charizard",
        "url": "https://pokeapi.co/api/v2/pokemon/6/"
      }
    },
    {
      "is_default": false,
      "pokemon": {
        "name": "charizard-mega-x",
        "url": "https://pokeapi.co/api/v2/pokemon/10034/"
      }
    },
    {
      "is_default": false,
      "pokemon": {
        "name": "charizard-mega-y",
        "url": "https://pokeapi.co/api/v2/pokemon/10035/"
      }
    },
    {
      "is_default": false,
      "pokemon": {
        "name": "charizard-gmax",
        "url": "https://pokeapi.co/api/v2/pokemon/10196/"
      }
    }
  ]
}"""

    val pokemonSterengthWeakness = """{
  "damage_relations": {
    "double_damage_from": [
      {
        "name": "fighting",
        "url": "https://pokeapi.co/api/v2/type/2/"
      },
      {
        "name": "ground",
        "url": "https://pokeapi.co/api/v2/type/5/"
      },
      {
        "name": "steel",
        "url": "https://pokeapi.co/api/v2/type/9/"
      },
      {
        "name": "water",
        "url": "https://pokeapi.co/api/v2/type/11/"
      },
      {
        "name": "grass",
        "url": "https://pokeapi.co/api/v2/type/12/"
      }
    ],
    "double_damage_to": [
      {
        "name": "flying",
        "url": "https://pokeapi.co/api/v2/type/3/"
      },
      {
        "name": "bug",
        "url": "https://pokeapi.co/api/v2/type/7/"
      },
      {
        "name": "fire",
        "url": "https://pokeapi.co/api/v2/type/10/"
      },
      {
        "name": "ice",
        "url": "https://pokeapi.co/api/v2/type/15/"
      }
    ],
    "half_damage_from": [
      {
        "name": "normal",
        "url": "https://pokeapi.co/api/v2/type/1/"
      },
      {
        "name": "flying",
        "url": "https://pokeapi.co/api/v2/type/3/"
      },
      {
        "name": "poison",
        "url": "https://pokeapi.co/api/v2/type/4/"
      },
      {
        "name": "fire",
        "url": "https://pokeapi.co/api/v2/type/10/"
      }
    ],
    "half_damage_to": [
      {
        "name": "fighting",
        "url": "https://pokeapi.co/api/v2/type/2/"
      },
      {
        "name": "ground",
        "url": "https://pokeapi.co/api/v2/type/5/"
      },
      {
        "name": "steel",
        "url": "https://pokeapi.co/api/v2/type/9/"
      }
    ],
    "no_damage_from": [],
    "no_damage_to": []
  },
  "game_indices": [
    {
      "game_index": 5,
      "generation": {
        "name": "generation-i",
        "url": "https://pokeapi.co/api/v2/generation/1/"
      }
    },
    {
      "game_index": 5,
      "generation": {
        "name": "generation-ii",
        "url": "https://pokeapi.co/api/v2/generation/2/"
      }
    },
    {
      "game_index": 5,
      "generation": {
        "name": "generation-iii",
        "url": "https://pokeapi.co/api/v2/generation/3/"
      }
    },
    {
      "game_index": 5,
      "generation": {
        "name": "generation-iv",
        "url": "https://pokeapi.co/api/v2/generation/4/"
      }
    },
    {
      "game_index": 5,
      "generation": {
        "name": "generation-v",
        "url": "https://pokeapi.co/api/v2/generation/5/"
      }
    },
    {
      "game_index": 5,
      "generation": {
        "name": "generation-vi",
        "url": "https://pokeapi.co/api/v2/generation/6/"
      }
    }
  ],
  "generation": {
    "name": "generation-i",
    "url": "https://pokeapi.co/api/v2/generation/1/"
  },
  "id": 6,
  "move_damage_class": {
    "name": "physical",
    "url": "https://pokeapi.co/api/v2/move-damage-class/2/"
  },
  "moves": [
    {
      "name": "rock-throw",
      "url": "https://pokeapi.co/api/v2/move/88/"
    },
    {
      "name": "rock-slide",
      "url": "https://pokeapi.co/api/v2/move/157/"
    },
    {
      "name": "sandstorm",
      "url": "https://pokeapi.co/api/v2/move/201/"
    },
    {
      "name": "rollout",
      "url": "https://pokeapi.co/api/v2/move/205/"
    },
    {
      "name": "ancient-power",
      "url": "https://pokeapi.co/api/v2/move/246/"
    },
    {
      "name": "rock-tomb",
      "url": "https://pokeapi.co/api/v2/move/317/"
    },
    {
      "name": "rock-blast",
      "url": "https://pokeapi.co/api/v2/move/350/"
    },
    {
      "name": "rock-polish",
      "url": "https://pokeapi.co/api/v2/move/397/"
    },
    {
      "name": "power-gem",
      "url": "https://pokeapi.co/api/v2/move/408/"
    },
    {
      "name": "rock-wrecker",
      "url": "https://pokeapi.co/api/v2/move/439/"
    },
    {
      "name": "stone-edge",
      "url": "https://pokeapi.co/api/v2/move/444/"
    },
    {
      "name": "stealth-rock",
      "url": "https://pokeapi.co/api/v2/move/446/"
    },
    {
      "name": "head-smash",
      "url": "https://pokeapi.co/api/v2/move/457/"
    },
    {
      "name": "wide-guard",
      "url": "https://pokeapi.co/api/v2/move/469/"
    },
    {
      "name": "smack-down",
      "url": "https://pokeapi.co/api/v2/move/479/"
    },
    {
      "name": "diamond-storm",
      "url": "https://pokeapi.co/api/v2/move/591/"
    },
    {
      "name": "continental-crush--physical",
      "url": "https://pokeapi.co/api/v2/move/632/"
    },
    {
      "name": "continental-crush--special",
      "url": "https://pokeapi.co/api/v2/move/633/"
    },
    {
      "name": "accelerock",
      "url": "https://pokeapi.co/api/v2/move/709/"
    },
    {
      "name": "splintered-stormshards",
      "url": "https://pokeapi.co/api/v2/move/727/"
    },
    {
      "name": "tar-shot",
      "url": "https://pokeapi.co/api/v2/move/749/"
    },
    {
      "name": "max-rockfall",
      "url": "https://pokeapi.co/api/v2/move/770/"
    },
    {
      "name": "meteor-beam",
      "url": "https://pokeapi.co/api/v2/move/800/"
    },
    {
      "name": "stone-axe",
      "url": "https://pokeapi.co/api/v2/move/830/"
    },
    {
      "name": "salt-cure",
      "url": "https://pokeapi.co/api/v2/move/864/"
    }
  ],
  "name": "rock",
  "names": [
    {
      "language": {
        "name": "ja-Hrkt",
        "url": "https://pokeapi.co/api/v2/language/1/"
      },
      "name": "いわ"
    },
    {
      "language": {
        "name": "ko",
        "url": "https://pokeapi.co/api/v2/language/3/"
      },
      "name": "바위"
    },
    {
      "language": {
        "name": "zh-Hant",
        "url": "https://pokeapi.co/api/v2/language/4/"
      },
      "name": "岩石"
    },
    {
      "language": {
        "name": "fr",
        "url": "https://pokeapi.co/api/v2/language/5/"
      },
      "name": "Roche"
    },
    {
      "language": {
        "name": "de",
        "url": "https://pokeapi.co/api/v2/language/6/"
      },
      "name": "Gestein"
    },
    {
      "language": {
        "name": "es",
        "url": "https://pokeapi.co/api/v2/language/7/"
      },
      "name": "Roca"
    },
    {
      "language": {
        "name": "it",
        "url": "https://pokeapi.co/api/v2/language/8/"
      },
      "name": "Roccia"
    },
    {
      "language": {
        "name": "en",
        "url": "https://pokeapi.co/api/v2/language/9/"
      },
      "name": "Rock"
    },
    {
      "language": {
        "name": "ja",
        "url": "https://pokeapi.co/api/v2/language/11/"
      },
      "name": "いわ"
    },
    {
      "language": {
        "name": "zh-Hans",
        "url": "https://pokeapi.co/api/v2/language/12/"
      },
      "name": "岩石"
    }
  ],
  "past_damage_relations": [],
  "pokemon": [
    {
      "pokemon": {
        "name": "geodude",
        "url": "https://pokeapi.co/api/v2/pokemon/74/"
      },
      "slot": 1
    },
    {
      "pokemon": {
        "name": "graveler",
        "url": "https://pokeapi.co/api/v2/pokemon/75/"
      },
      "slot": 1
    },
    {
      "pokemon": {
        "name": "golem",
        "url": "https://pokeapi.co/api/v2/pokemon/76/"
      },
      "slot": 1
    },
    {
      "pokemon": {
        "name": "onix",
        "url": "https://pokeapi.co/api/v2/pokemon/95/"
      },
      "slot": 1
    }
  ]
}"""

    val pokemonTypes = """{
"count": 20,
"next": null,
"previous": null,
"results": [
{
"name": "normal",
"url": "https://pokeapi.co/api/v2/type/1/"
},
{
"name": "fighting",
"url": "https://pokeapi.co/api/v2/type/2/"
},
{
"name": "flying",
"url": "https://pokeapi.co/api/v2/type/3/"
},
{
"name": "poison",
"url": "https://pokeapi.co/api/v2/type/4/"
},
{
"name": "ground",
"url": "https://pokeapi.co/api/v2/type/5/"
},
{
"name": "rock",
"url": "https://pokeapi.co/api/v2/type/6/"
},
{
"name": "bug",
"url": "https://pokeapi.co/api/v2/type/7/"
},
{
"name": "ghost",
"url": "https://pokeapi.co/api/v2/type/8/"
},
{
"name": "steel",
"url": "https://pokeapi.co/api/v2/type/9/"
},
{
"name": "fire",
"url": "https://pokeapi.co/api/v2/type/10/"
},
{
"name": "water",
"url": "https://pokeapi.co/api/v2/type/11/"
},
{
"name": "grass",
"url": "https://pokeapi.co/api/v2/type/12/"
},
{
"name": "electric",
"url": "https://pokeapi.co/api/v2/type/13/"
},
{
"name": "psychic",
"url": "https://pokeapi.co/api/v2/type/14/"
},
{
"name": "ice",
"url": "https://pokeapi.co/api/v2/type/15/"
},
{
"name": "dragon",
"url": "https://pokeapi.co/api/v2/type/16/"
},
{
"name": "dark",
"url": "https://pokeapi.co/api/v2/type/17/"
},
{
"name": "fairy",
"url": "https://pokeapi.co/api/v2/type/18/"
},
{
"name": "unknown",
"url": "https://pokeapi.co/api/v2/type/10001/"
},
{
"name": "shadow",
"url": "https://pokeapi.co/api/v2/type/10002/"
}
]
}"""

    val pokemonGenders = """{
"count": 3,
"next": null,
"previous": null,
"results": [
{
"name": "female",
"url": "https://pokeapi.co/api/v2/gender/1/"
},
{
"name": "male",
"url": "https://pokeapi.co/api/v2/gender/2/"
},
{
"name": "genderless",
"url": "https://pokeapi.co/api/v2/gender/3/"
}
]
}"""

    val pokemonEvolutionChain = """{
"baby_trigger_item": null,
"chain": {
"evolution_details": [],
"evolves_to": [
{
"evolution_details": [
{
"gender": null,
"held_item": null,
"item": null,
"known_move": null,
"known_move_type": null,
"location": null,
"min_affection": null,
"min_beauty": null,
"min_happiness": null,
"min_level": 18,
"needs_overworld_rain": false,
"party_species": null,
"party_type": null,
"relative_physical_stats": null,
"time_of_day": "",
"trade_species": null,
"trigger": {
"name": "level-up",
"url": "https://pokeapi.co/api/v2/evolution-trigger/1/"
},
"turn_upside_down": false
}
],
"evolves_to": [
{
"evolution_details": [
{
"gender": null,
"held_item": null,
"item": null,
"known_move": null,
"known_move_type": null,
"location": null,
"min_affection": null,
"min_beauty": null,
"min_happiness": null,
"min_level": 36,
"needs_overworld_rain": false,
"party_species": null,
"party_type": null,
"relative_physical_stats": null,
"time_of_day": "",
"trade_species": null,
"trigger": {
"name": "level-up",
"url": "https://pokeapi.co/api/v2/evolution-trigger/1/"
},
"turn_upside_down": false
}
],
"evolves_to": [],
"is_baby": false,
"species": {
"name": "pidgeot",
"url": "https://pokeapi.co/api/v2/pokemon-species/18/"
}
}
],
"is_baby": false,
"species": {
"name": "pidgeotto",
"url": "https://pokeapi.co/api/v2/pokemon-species/17/"
}
}
],
"is_baby": false,
"species": {
"name": "pidgey",
"url": "https://pokeapi.co/api/v2/pokemon-species/16/"
}
},
"id": 6
}"""
}