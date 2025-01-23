package com.dcac.mycity.datasource.localPlacesCityDataProvider

import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.Place

object LocalPlacesLondonDataProvider {
    val londonPlaces = listOf(
        // Museums
        Place(
            id = 1L,
            name = "British Museum",
            imageResourceId = R.drawable.image_british_museum,
            description = "A public institution dedicated to human history, art, and culture.",
            streetAddress = "Great Russell St",
            cityLocation = "London WC1B 3DG",
            openingHours = "10:00 - 17:30",
            category = Category.MUSEUM
        ),
        Place(
            id = 2L,
            name = "National Gallery",
            imageResourceId = R.drawable.image_national_gallery,
            description = "Home to one of the world's greatest collections of paintings.",
            streetAddress = "Trafalgar Square",
            cityLocation = "London WC2N 5DN",
            openingHours = "10:00 - 18:00",
            category = Category.MUSEUM
        ),
        Place(
            id = 3L,
            name = "Natural History Museum",
            imageResourceId = R.drawable.image_natural_history_museum,
            description = "Features exhibits on natural history, including a life-sized dinosaur skeleton.",
            streetAddress = "Cromwell Rd, South Kensington",
            cityLocation = "London SW7 5BD",
            openingHours = "10:00 - 17:50",
            category = Category.MUSEUM
        ),
        Place(
            id = 4L,
            name = "Tate Modern",
            imageResourceId = R.drawable.image_natural_tate_modern,
            description = "A modern art gallery housed in a former power station.",
            streetAddress = "Bankside",
            cityLocation = "London SE1 9TG",
            openingHours = "10:00 - 18:00",
            category = Category.MUSEUM
        ),
        Place(
            id = 5L,
            name = "Victoria and Albert Museum",
            imageResourceId = R.drawable.image_victoria_albert_museum,
            description = "The world's largest museum of applied and decorative arts and design.",
            streetAddress = "Cromwell Rd",
            cityLocation = "London SW7 2RL",
            openingHours = "10:00 - 17:45",
            category = Category.MUSEUM
        ),
        // Malls
        Place(
            id = 6L,
            name = "Westfield London",
            imageResourceId = R.drawable.image_westfield,
            description = "One of the largest shopping malls in Europe, featuring luxury and high-street brands.",
            streetAddress = "Ariel Way",
            cityLocation = "London W12 7GF",
            openingHours = "10:00 - 22:00",
            category = Category.MAUL
        ),
        Place(
            id = 7L,
            name = "Canary Wharf Shopping Centre",
            imageResourceId = R.drawable.image_canary_wharf,
            description = "A modern shopping destination with designer brands and eateries.",
            streetAddress = "Canada Square",
            cityLocation = "London E14 5AB",
            openingHours = "10:00 - 21:00",
            category = Category.MAUL
        ),
        Place(
            id = 8L,
            name = "One New Change",
            imageResourceId = R.drawable.image_one_new_change,
            description = "A stylish shopping center with rooftop views of St. Paul's Cathedral.",
            streetAddress = "1 New Change",
            cityLocation = "London EC4M 9AF",
            openingHours = "10:00 - 20:00",
            category = Category.MAUL
        ),
        Place(
            id = 9L,
            name = "Brent Cross",
            imageResourceId = R.drawable.image_brent_cross,
            description = "One of the UK's first indoor shopping malls, offering a wide range of stores.",
            streetAddress = "Prince Charles Dr",
            cityLocation = "London NW4 3FP",
            openingHours = "10:00 - 20:00",
            category = Category.MAUL
        ),
        Place(
            id = 10L,
            name = "Royal Exchange",
            imageResourceId = R.drawable.image_royal_exchange,
            description = "A luxury shopping arcade in the heart of London's financial district.",
            streetAddress = "Royal Exchange",
            cityLocation = "London EC3V 3DG",
            openingHours = "10:00 - 19:00",
            category = Category.MAUL
        ),
        // Restaurants
        Place(
            id = 11L,
            name = "Dishoom Covent Garden",
            imageResourceId = R.drawable.image_dishoom,
            description = "Popular restaurant serving Bombay-style cuisine.",
            streetAddress = "12 Upper St Martin's Ln",
            cityLocation = "London WC2H 9FB",
            openingHours = "08:00 - 23:00",
            category = Category.RESTAURANT
        ),
        Place(
            id = 12L,
            name = "Sketch",
            imageResourceId = R.drawable.image_sketch,
            description = "Quirky dining experience with artful interiors and fine European cuisine.",
            streetAddress = "9 Conduit St",
            cityLocation = "London W1S 2XG",
            openingHours = "12:00 - 00:00",
            category = Category.RESTAURANT
        ),
        Place(
            id = 13L,
            name = "Hawksmoor Seven Dials",
            imageResourceId = R.drawable.image_hawksmoore,
            description = "Renowned steakhouse offering premium cuts and classic cocktails.",
            streetAddress = "11 Langley St",
            cityLocation = "London WC2H 9JG",
            openingHours = "12:00 - 23:00",
            category = Category.RESTAURANT
        ),
        Place(
            id = 14L,
            name = "Gymkhana",
            imageResourceId = R.drawable.image_gymkhana,
            description = "Michelin-starred Indian restaurant with a colonial-era club vibe.",
            streetAddress = "42 Albemarle St",
            cityLocation = "London W1S 4JH",
            openingHours = "12:00 - 14:30, 18:00 - 22:30",
            category = Category.RESTAURANT
        ),
        Place(
            id = 15L,
            name = "The Ledbury",
            imageResourceId = R.drawable.image_the_ledbury,
            description = "Elegant fine-dining restaurant with two Michelin stars.",
            streetAddress = "127 Ledbury Rd",
            cityLocation = "London W11 2AQ",
            openingHours = "12:00 - 14:30, 19:00 - 21:30",
            category = Category.RESTAURANT
        ),
        // Bars
        Place(
            id = 16L,
            name = "Nightjar",
            imageResourceId = R.drawable.image_nightjar,
            description = "Speakeasy-style bar offering creative cocktails and live jazz.",
            streetAddress = "129 City Rd",
            cityLocation = "London EC1V 1JB",
            openingHours = "17:00 - 01:00",
            category = Category.BAR
        ),
        Place(
            id = 17L,
            name = "The Alchemist",
            imageResourceId = R.drawable.image_the_alchemist,
            description = "A bar known for theatrical cocktails with a magical twist.",
            streetAddress = "6 Bevis Marks",
            cityLocation = "London EC3A 7BA",
            openingHours = "11:00 - 23:00",
            category = Category.BAR
        ),
        Place(
            id = 18L,
            name = "Callooh Callay",
            imageResourceId = R.drawable.image_callooh_callay,
            description = "Award-winning cocktail bar with a quirky, Alice in Wonderland-inspired interior.",
            streetAddress = "65 Rivington St",
            cityLocation = "London EC2A 3AY",
            openingHours = "16:00 - 00:00",
            category = Category.BAR
        ),
        Place(
            id = 19L,
            name = "The Churchill Bar",
            imageResourceId = R.drawable.image_churchill_bar,
            description = "Stylish bar with a terrace, serving Winston Churchill-inspired cocktails.",
            streetAddress = "30 Portman Square",
            cityLocation = "London W1H 7BH",
            openingHours = "12:00 - 00:00",
            category = Category.BAR
        ),
        Place(
            id = 20L,
            name = "Bar Termini",
            imageResourceId = R.drawable.image_bar_termini,
            description = "An intimate bar offering Italian cocktails and classic aperitivos.",
            streetAddress = "7 Old Compton St",
            cityLocation = "London W1D 5JE",
            openingHours = "12:00 - 00:00",
            category = Category.BAR
        ),
        // Nightclubs
        Place(
            id = 21L,
            name = "Fabric",
            imageResourceId = R.drawable.image_fabric,
            description = "Famous nightclub with world-class DJs and electronic music.",
            streetAddress = "77A Charterhouse St",
            cityLocation = "London EC1M 6HJ",
            openingHours = "22:00 - 06:00",
            category = Category.NIGHTCLUB
        ),
        Place(
            id = 22L,
            name = "Ministry of Sound",
            imageResourceId = R.drawable.image_ministry_of_sound,
            description = "Iconic club known for its state-of-the-art sound system and international DJs.",
            streetAddress = "103 Gaunt St",
            cityLocation = "London SE1 6DP",
            openingHours = "23:00 - 06:00",
            category = Category.NIGHTCLUB
        ),
        Place(
            id = 23L,
            name = "Heaven",
            imageResourceId = R.drawable.image_heaven,
            description = "A legendary LGBTQ+ nightclub featuring pop and electronic music.",
            streetAddress = "The Arches, Villiers St",
            cityLocation = "London WC2N 6NG",
            openingHours = "22:00 - 05:00",
            category = Category.NIGHTCLUB
        ),
        Place(
            id = 24L,
            name = "Egg London",
            imageResourceId = R.drawable.image_egg_london,
            description = "A multi-level club with a garden terrace, playing techno and house music.",
            streetAddress = "200 York Way",
            cityLocation = "London N7 9AX",
            openingHours = "22:00 - 07:00",
            category = Category.NIGHTCLUB
        ),
        Place(
            id = 25L,
            name = "XOYO",
            imageResourceId = R.drawable.image_xoyo,
            description = "Trendy nightclub hosting live music events and international DJs.",
            streetAddress = "32-37 Cowper St",
            cityLocation = "London EC2A 4AP",
            openingHours = "21:00 - 03:00",
            category = Category.NIGHTCLUB
        )
    )
}