package com.dcac.mycity.datasource.localPlacesCityDataProvider

import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.Place

object LocalPlacesParisDataProvider {
    val parisPlaces = listOf(
        // Museums
        Place(
            id = 1L,
            name = "Musee du Louvre",
            imageResourceId = R.drawable.image_louvre, // Image placeholder
            description = "Famous museum housing the Mona Lisa and countless masterpieces.",
            streetAddress = "Rue de Rivoli",
            cityLocation = "75001 Paris",
            openingHours = "09:00 - 18:00",
            category = Category.museum
        ),
        Place(
            id = 2L,
            name = "Musee d'Orsay",
            imageResourceId = R.drawable.image_musee_orsay,
            description = "Art museum featuring impressionist and post-impressionist masterpieces.",
            streetAddress = "1 Rue de la Légion d'Honneur",
            cityLocation = "75007 Paris",
            openingHours = "09:30 - 18:00",
            category = Category.museum
        ),
        Place(
            id = 3L,
            name = "Centre Pompidou",
            imageResourceId = R.drawable.image_centre_pompidou,
            description = "Modern art museum with a distinctive architectural style.",
            streetAddress = "Place Georges-Pompidou",
            cityLocation = "75004 Paris",
            openingHours = "11:00 - 21:00",
            category = Category.museum
        ),
        Place(
            id = 4L,
            name = "Musee de Rodin",
            imageResourceId = R.drawable.image_musee_rodin,
            description = "Museum showcasing works of sculptor Auguste Rodin.",
            streetAddress = "77 Rue de Varenne",
            cityLocation = "75007 Paris",
            openingHours = "10:00 - 18:30",
            category = Category.museum
        ),
        Place(
            id = 5L,
            name = "Musee de l'Orangerie",
            imageResourceId = R.drawable.image_musee_orangerie,
            description = "Museum displaying Monet's Water Lilies and other impressionist works.",
            streetAddress = "Jardin Tuileries",
            cityLocation = "75001 Paris",
            openingHours = "09:00 - 18:00",
            category = Category.museum
        ),
        // Malls
        Place(
            id = 6L,
            name = "Forum des Halles",
            imageResourceId = R.drawable.image_forum_halles,
            description = "A large underground shopping mall in the heart of Paris.",
            streetAddress = "101 Porte Berger",
            cityLocation = "75001 Paris",
            openingHours = "10:00 - 20:00",
            category = Category.maul
        ),
        Place(
            id = 7L,
            name = "Carrousel du Louvre",
            imageResourceId = R.drawable.image_carrousel_louvre,
            description = "Upscale shopping mall located below the Louvre Museum.",
            streetAddress = "99 Rue de Rivoli",
            cityLocation = "75001 Paris",
            openingHours = "10:00 - 19:30",
            category = Category.maul
        ),
        Place(
            id = 8L,
            name = "Galeries Lafayette",
            imageResourceId = R.drawable.image_galeries_lafayette,
            description = "Renowned department store offering luxury fashion and products.",
            streetAddress = "40 Boulevard Haussmann",
            cityLocation = "75009 Paris",
            openingHours = "09:30 - 20:30",
            category = Category.maul
        ),
        Place(
            id = 9L,
            name = "Bercy Village",
            imageResourceId = R.drawable.image_bercy_village,
            description = "Charming shopping and dining area in former wine warehouses.",
            streetAddress = "Cour Saint-Émilion",
            cityLocation = "75012 Paris",
            openingHours = "10:00 - 22:00",
            category = Category.maul
        ),
        Place(
            id = 10L,
            name = "Le Bon Marché",
            imageResourceId = R.drawable.image_bon_marche,
            description = "Prestigious department store offering high-end products.",
            streetAddress = "24 Rue de Sèvres",
            cityLocation = "75007 Paris",
            openingHours = "10:00 - 20:00",
            category = Category.maul
        ),
        // Restaurants
        Place(
            id = 16L,
            name = "Tonton de la Butte",
            imageResourceId = R.drawable.image_tonton_butte,
            description = "Meat restaurant with classic French dishes",
            streetAddress = "62 Rue Caulaincourt",
            cityLocation = "75018 Paris",
            openingHours = "12:00 - 14:30, 19:00 - 2:00",
            category = Category.restaurant
        ),
        Place(
            id = 17L,
            name = "Gaston",
            imageResourceId = R.drawable.image_gaston,
            description = "French restaurant serving traditional cuisine in a decor of clocks and exposed bricks.",
            streetAddress = "11 Rue Brochant",
            cityLocation = "75017 Paris",
            openingHours = "11:30 - 14:30, 19:00 - 22:30",
            category = Category.restaurant
        ),
        Place(
            id = 18L,
            name = "Mori Venice Bar",
            imageResourceId = R.drawable.image_mori,
            description = "Restaurant offering Italian cuisine in a modern, refined Venetian-inspired decor.",
            streetAddress = "27 Rue de Richelieu",
            cityLocation = "75001 Paris",
            openingHours = "12:00 - 14:00, 19:30 - 23:00",
            category = Category.restaurant
        ),
        Place(
            id = 19L,
            name = "Kiyo Aji",
            imageResourceId = R.drawable.image_kiyo,
            description = "Teppanyaki restaurant serving the finest Japanese dishes",
            streetAddress = "15 Rue Caulaincourt",
            cityLocation = "75018 Paris",
            openingHours = "19:30 - 21:30",
            category = Category.restaurant
        ),
        Place(
            id = 20L,
            name = "Sphere",
            imageResourceId = R.drawable.image_sphere,
            description = "Fusion food gastronomic restaurant",
            streetAddress = "18 Rue La Boétie",
            cityLocation = "75008 Paris",
            openingHours = "12:00 - 14:30, 19:00 - 22:30",
            category = Category.restaurant
        ),
        // Bars
        Place(
            id = 11L,
            name = "Dikkenek",
            imageResourceId = R.drawable.image_dikkenek,
            description = "Neighborhood bar with good ambiance and cheap drinks.",
            streetAddress = "59 Rue Ramey",
            cityLocation = "75018 Paris",
            openingHours = "16:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 12L,
            name = "Octopussy",
            imageResourceId = R.drawable.image_octopussy,
            description = "Trendy bar with indie rock posters, renowned for its craft beers and quiz nights.",
            streetAddress = "22 Rue de La Jonquière",
            cityLocation = "75017 Paris",
            openingHours = "18:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 13L,
            name = "Bar à Bulles",
            imageResourceId = R.drawable.image_bar_bulles,
            description = "Relaxed, artistic atmosphere with a leafy terrace serving brunch and tapas.",
            streetAddress = "4 Cité Véron",
            cityLocation = "75018 Paris",
            openingHours = "18:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 14L,
            name = "Le Comptoir General",
            imageResourceId = R.drawable.image_comptoir_general,
            description = "Rustic-chic bar with a leafy terrace serving cocktails and classic fish dishes.",
            streetAddress = "84 Quai de Jemmapes",
            cityLocation = "75010 Paris",
            openingHours = "17:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 15L,
            name = "Le Perchoir",
            imageResourceId = R.drawable.image_le_perchoir,
            description = "Rooftop bar offering stunning views of Paris.",
            streetAddress = "14 Rue Crespin du Gast",
            cityLocation = "75011 Paris",
            openingHours = "18:00 - 01:30",
            category = Category.bar
        ),
        // Nightclubs
        Place(
            id = 21L,
            name = "Rex Club",
            imageResourceId = R.drawable.image_rex_club,
            description = "Legendary nightclub with a focus on electronic music.",
            streetAddress = "5 Boulevard Poissonnière",
            cityLocation = "75002 Paris",
            openingHours = "23:30 - 06:00",
            category = Category.nightclub
        ),
        Place(
            id = 22L,
            name = "La Machine du Moulin Rouge",
            imageResourceId = R.drawable.image_la_machine_moulin_rouge,
            description = "Historic venue offering a mix of live music and clubbing experiences.",
            streetAddress = "90 Boulevard de Clichy",
            cityLocation = "75018 Paris",
            openingHours = "23:00 - 06:00",
            category = Category.nightclub
        ),
        Place(
            id = 23L,
            name = "La Bellevilloise",
            imageResourceId = R.drawable.image_la_bellevilloise,
            description = "Vibrant cultural space hosting concerts, club nights, and art events.",
            streetAddress = "19-21 Rue Boyer",
            cityLocation = "75020 Paris",
            openingHours = "20:00 - 05:00",
            category = Category.nightclub
        ),
        Place(
            id = 24L,
            name = "Le Sacré",
            imageResourceId = R.drawable.image_le_sacre,
            description = "Trendy club known for its eclectic music and underground vibe.",
            streetAddress = "142 Rue Montmartre",
            cityLocation = "75002 Paris",
            openingHours = "22:30 - 05:00",
            category = Category.nightclub
        ),
        Place(
            id = 25L,
            name = "Silencio",
            imageResourceId = R.drawable.image_silencio,
            description = "Exclusive club designed by David Lynch for a sophisticated nightlife experience.",
            streetAddress = "144 Rue Montmartre",
            cityLocation = "75002 Paris",
            openingHours = "18:00 - 04:00",
            category = Category.nightclub
        )
    )
}