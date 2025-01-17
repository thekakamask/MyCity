package com.dcac.mycity.datasource.localPlacesCityDataProvider

import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.Place

object LocalPlacesNewYorkDataProvider {
    val newYorkPlaces = listOf(
        // Museums
        Place(
            id = 1L,
            name = "The Metropolitan Museum of Art",
            imageResourceId = R.drawable.image_metropolitan_museum,
            description = "One of the largest art museums in the world, showcasing thousands of works.",
            address = "1000 5th Ave, New York, NY 10028",
            openingHours = "10:00 - 17:30",
            category = Category.museum
        ),
        Place(
            id = 2L,
            name = "Museum of Modern Art (MoMA)",
            imageResourceId = R.drawable.image_moma,
            description = "A world-renowned museum featuring modern and contemporary art.",
            address = "11 W 53rd St, New York, NY 10019",
            openingHours = "10:30 - 17:30",
            category = Category.museum
        ),
        Place(
            id = 3L,
            name = "American Museum of Natural History",
            imageResourceId = R.drawable.image_amnh,
            description = "A museum dedicated to exploring the natural world and the universe.",
            address = "200 Central Park West, New York, NY 10024",
            openingHours = "10:00 - 17:30",
            category = Category.museum
        ),
        Place(
            id = 4L,
            name = "Whitney Museum of American Art",
            imageResourceId = R.drawable.image_whitney_museum,
            description = "Showcasing 20th- and 21st-century American art.",
            address = "99 Gansevoort St, New York, NY 10014",
            openingHours = "10:30 - 18:00",
            category = Category.museum
        ),
        Place(
            id = 5L,
            name = "Solomon R. Guggenheim Museum",
            imageResourceId = R.drawable.image_guggenheim,
            description = "Famous for its modern art collection and unique architecture by Frank Lloyd Wright.",
            address = "1071 5th Ave, New York, NY 10128",
            openingHours = "11:00 - 18:00",
            category = Category.museum
        ),

        // Malls
        Place(
            id = 6L,
            name = "Westfield World Trade Center",
            imageResourceId = R.drawable.image_westfield_wtc,
            description = "A shopping mall located at the World Trade Center, featuring luxury and high-street brands.",
            address = "185 Greenwich St, New York, NY 10007",
            openingHours = "10:00 - 20:00",
            category = Category.maul
        ),
        Place(
            id = 7L,
            name = "The Shops at Columbus Circle",
            imageResourceId = R.drawable.image_columbus_circle,
            description = "Upscale shopping and dining at the heart of Manhattan.",
            address = "10 Columbus Cir, New York, NY 10019",
            openingHours = "10:00 - 21:00",
            category = Category.maul
        ),
        Place(
            id = 8L,
            name = "Manhattan Mall",
            imageResourceId = R.drawable.image_manhattan_mall,
            description = "A mid-sized shopping mall offering a range of brands and eateries.",
            address = "100 W 33rd St, New York, NY 10001",
            openingHours = "10:00 - 21:00",
            category = Category.maul
        ),
        Place(
            id = 9L,
            name = "Brookfield Place",
            imageResourceId = R.drawable.image_brookfield_place,
            description = "An elegant waterfront shopping center featuring luxury brands and fine dining.",
            address = "230 Vesey St, New York, NY 10281",
            openingHours = "10:00 - 20:00",
            category = Category.maul
        ),
        Place(
            id = 10L,
            name = "Queens Center Mall",
            imageResourceId = R.drawable.image_queens_center_mall,
            description = "A popular shopping mall in Queens with a variety of retailers.",
            address = "90-15 Queens Blvd, Elmhurst, NY 11373",
            openingHours = "10:00 - 21:30",
            category = Category.maul
        ),

        // Restaurants
        Place(
            id = 11L,
            name = "Katz's Delicatessen",
            imageResourceId = R.drawable.image_katz_deli,
            description = "Famous for its pastrami sandwiches and New York deli experience.",
            address = "205 E Houston St, New York, NY 10002",
            openingHours = "08:00 - 22:45",
            category = Category.restaurant
        ),
        Place(
            id = 12L,
            name = "Le Bernardin",
            imageResourceId = R.drawable.image_le_bernardin,
            description = "Michelin-starred restaurant specializing in seafood dishes.",
            address = "155 W 51st St, New York, NY 10019",
            openingHours = "12:00 - 14:30, 17:30 - 22:30",
            category = Category.restaurant
        ),
        Place(
            id = 13L,
            name = "Shake Shack",
            imageResourceId = R.drawable.image_shake_shack,
            description = "Casual eatery known for its burgers, fries, and milkshakes.",
            address = "Madison Square Park, New York, NY 10010",
            openingHours = "11:00 - 22:00",
            category = Category.restaurant
        ),
        Place(
            id = 14L,
            name = "Peter Luger Steakhouse",
            imageResourceId = R.drawable.image_peter_luger,
            description = "Legendary steakhouse with old-school charm and top-quality steaks.",
            address = "178 Broadway, Brooklyn, NY 11211",
            openingHours = "12:00 - 21:30",
            category = Category.restaurant
        ),
        Place(
            id = 15L,
            name = "Momofuku Noodle Bar",
            imageResourceId = R.drawable.image_momofuku_noodle,
            description = "Modern ramen and Asian-inspired dishes by Chef David Chang.",
            address = "171 1st Avenue, New York, NY 10003",
            openingHours = "12:00 - 22:00",
            category = Category.restaurant
        ),
        // Bars
        Place(
            id = 16L,
            name = "The Dead Rabbit",
            imageResourceId = R.drawable.image_dead_rabbit,
            description = "Award-winning bar known for its creative cocktails and Irish charm.",
            address = "30 Water St, New York, NY 10004",
            openingHours = "11:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 17L,
            name = "PDT (Please Don't Tell)",
            imageResourceId = R.drawable.image_pdt,
            description = "A hidden speakeasy-style bar accessed through a phone booth in Crif Dogs.",
            address = "113 St Marks Pl, New York, NY 10009",
            openingHours = "17:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 18L,
            name = "Employees Only",
            imageResourceId = R.drawable.image_employees_only,
            description = "A stylish cocktail bar with a Prohibition-era vibe and a late-night menu.",
            address = "510 Hudson St, New York, NY 10014",
            openingHours = "17:00 - 04:00",
            category = Category.bar
        ),
        Place(
            id = 19L,
            name = "Attaboy",
            imageResourceId = R.drawable.image_attaboy,
            description = "An intimate bar offering bespoke cocktails tailored to your preferences.",
            address = "134 Eldridge St, New York, NY 10002",
            openingHours = "18:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 20L,
            name = "The Campbell",
            imageResourceId = R.drawable.image_the_campbell,
            description = "A grand, elegant bar located in a historic train station setting.",
            address = "15 Vanderbilt Ave, New York, NY 10017",
            openingHours = "12:00 - 00:00",
            category = Category.bar
        ),
        //Nightclub
        Place(
            id = 21L,
            name = "Marquee New York",
            imageResourceId = R.drawable.image_marquee_nyc,
            description = "High-energy nightclub with international DJs and luxurious ambiance.",
            address = "289 10th Ave, New York, NY 10001",
            openingHours = "23:00 - 04:00",
            category = Category.nightclub
        ),
        Place(
            id = 22L,
            name = "LAVO Nightclub",
            imageResourceId = R.drawable.image_lavo,
            description = "Upscale nightclub featuring top DJs and a lively dance floor.",
            address = "39 E 58th St, New York, NY 10022",
            openingHours = "23:00 - 04:00",
            category = Category.nightclub
        ),
        Place(
            id = 23L,
            name = "Webster Hall",
            imageResourceId = R.drawable.image_webster_hall,
            description = "Iconic venue hosting live music and late-night dance parties.",
            address = "125 E 11th St, New York, NY 10003",
            openingHours = "22:00 - 04:00",
            category = Category.nightclub
        ),
        Place(
            id = 24L,
            name = "Output",
            imageResourceId = R.drawable.image_output,
            description = "Brooklyn-based nightclub focusing on electronic music and top-tier DJs.",
            address = "74 Wythe Ave, Brooklyn, NY 11249",
            openingHours = "22:00 - 06:00",
            category = Category.nightclub
        ),
        Place(
            id = 25L,
            name = "1 OAK",
            imageResourceId = R.drawable.image_one_oak,
            description = "Exclusive and trendy nightclub attracting celebrities and A-list crowds.",
            address = "453 W 17th St, New York, NY 10011",
            openingHours = "23:00 - 04:00",
            category = Category.nightclub
        ),
    )
}