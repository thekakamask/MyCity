package com.dcac.mycity.datasource.localPlacesCityDataProvider

import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.Place

object LocalPlacesRomeDataProvider {
    val romePlaces = listOf(
        // Museums
        Place(
            id = 1L,
            name = "Vatican Museums",
            imageResourceId = R.drawable.image_vatican_museums,
            description = "A treasure trove of art and history, featuring the Sistine Chapel.",
            address = "Viale Vaticano, 00165 Roma RM, Italy",
            openingHours = "09:00 - 18:00",
            category = Category.museum
        ),
        Place(
            id = 2L,
            name = "Capitoline Museums",
            imageResourceId = R.drawable.image_capitoline_museums,
            description = "Ancient art and artifacts on Capitoline Hill.",
            address = "Piazza del Campidoglio, 1, 00186 Roma RM, Italy",
            openingHours = "09:30 - 19:30",
            category = Category.museum
        ),
        Place(
            id = 3L,
            name = "Galleria Borghese",
            imageResourceId = R.drawable.image_galleria_borghese,
            description = "A magnificent collection of Baroque art in a historic villa.",
            address = "Piazzale Scipione Borghese, 5, 00197 Roma RM, Italy",
            openingHours = "09:00 - 19:00",
            category = Category.museum
        ),
        Place(
            id = 4L,
            name = "National Roman Museum",
            imageResourceId = R.drawable.image_national_roman_museum,
            description = "Fascinating exhibits of Roman sculptures and artifacts.",
            address = "Largo di Villa Peretti, 1, 00185 Roma RM, Italy",
            openingHours = "09:00 - 19:45",
            category = Category.museum
        ),
        Place(
            id = 5L,
            name = "MAXXI - National Museum of 21st Century Arts",
            imageResourceId = R.drawable.image_maxxi,
            description = "A modern museum focusing on contemporary art and architecture.",
            address = "Via Guido Reni, 4A, 00196 Roma RM, Italy",
            openingHours = "11:00 - 19:00",
            category = Category.museum
        ),

        // Malls
        Place(
            id = 6L,
            name = "Roma Est Shopping Center",
            imageResourceId = R.drawable.image_roma_est,
            description = "A modern shopping center with international brands and dining.",
            address = "Via Collatina, 858, 00132 Roma RM, Italy",
            openingHours = "10:00 - 21:00",
            category = Category.maul
        ),
        Place(
            id = 7L,
            name = "Euroma2",
            imageResourceId = R.drawable.image_euroma2,
            description = "A grand mall featuring luxury stores and elegant decor.",
            address = "Viale dell'Oceano Pacifico, 83, 00144 Roma RM, Italy",
            openingHours = "10:00 - 21:00",
            category = Category.maul
        ),
        Place(
            id = 8L,
            name = "Centro Commerciale Porta di Roma",
            imageResourceId = R.drawable.image_porta_di_roma,
            description = "A large shopping mall offering a wide variety of stores and services.",
            address = "Via Alberto Lionello, 201, 00139 Roma RM, Italy",
            openingHours = "10:00 - 22:00",
            category = Category.maul
        ),
        Place(
            id = 9L,
            name = "Centro Commerciale Cinecittà Due",
            imageResourceId = R.drawable.image_cinecitta_due,
            description = "A shopping center with stores, eateries, and entertainment.",
            address = "Viale Palmiro Togliatti, 2, 00173 Roma RM, Italy",
            openingHours = "10:00 - 20:00",
            category = Category.maul
        ),
        Place(
            id = 10L,
            name = "La Rinascente",
            imageResourceId = R.drawable.image_la_rinascente,
            description = "An upscale department store with a rooftop terrace offering views of Rome.",
            address = "Via del Tritone, 61, 00187 Roma RM, Italy",
            openingHours = "10:00 - 21:00",
            category = Category.maul
        ),

        // Restaurants
        Place(
            id = 11L,
            name = "Roscioli",
            imageResourceId = R.drawable.image_roscioli,
            description = "A renowned Italian deli offering traditional Roman dishes and fine wines.",
            address = "Via dei Giubbonari, 21, 00186 Roma RM, Italy",
            openingHours = "12:30 - 23:00",
            category = Category.restaurant
        ),
        Place(
            id = 12L,
            name = "Da Enzo al 29",
            imageResourceId = R.drawable.image_da_enzo,
            description = "Cozy trattoria serving authentic Roman cuisine.",
            address = "Via dei Vascellari, 29, 00153 Roma RM, Italy",
            openingHours = "12:00 - 15:00, 19:00 - 23:00",
            category = Category.restaurant
        ),
        Place(
            id = 13L,
            name = "La Pergola",
            imageResourceId = R.drawable.image_la_pergola,
            description = "Michelin-starred restaurant offering fine dining with panoramic views.",
            address = "Via Alberto Cadlolo, 101, 00136 Roma RM, Italy",
            openingHours = "19:30 - 23:30",
            category = Category.restaurant
        ),
        Place(
            id = 14L,
            name = "Sora Lella",
            imageResourceId = R.drawable.image_sora_lella,
            description = "Family-run restaurant known for traditional Roman recipes.",
            address = "Via di Ponte Quattro Capi, 16, 00186 Roma RM, Italy",
            openingHours = "12:00 - 22:30",
            category = Category.restaurant
        ),
        Place(
            id = 15L,
            name = "Trattoria Pennestri",
            imageResourceId = R.drawable.image_trattoria_pennestri,
            description = "Modern trattoria blending Roman traditions with contemporary flavors.",
            address = "Via Giovanni da Empoli, 5, 00154 Roma RM, Italy",
            openingHours = "12:30 - 15:00, 19:30 - 23:00",
            category = Category.restaurant
        ),

        // Bars
        Place(
            id = 16L,
            name = "Jerry Thomas Speakeasy",
            imageResourceId = R.drawable.image_jerry_thomas,
            description = "A hidden cocktail bar with vintage-style drinks.",
            address = "Vicolo Cellini, 30, 00186 Roma RM, Italy",
            openingHours = "19:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 17L,
            name = "Freni e Frizioni",
            imageResourceId = R.drawable.image_freni_e_frizioni,
            description = "Trendy cocktail bar in Trastevere offering creative drinks and snacks.",
            address = "Via del Politeama, 4, 00153 Roma RM, Italy",
            openingHours = "18:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 18L,
            name = "Bar del Fico",
            imageResourceId = R.drawable.image_bar_del_fico,
            description = "Lively bar near Piazza Navona, famous for its Aperol Spritz and vibrant atmosphere.",
            address = "Piazza del Fico, 26, 00186 Roma RM, Italy",
            openingHours = "12:00 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 19L,
            name = "Drink Kong",
            imageResourceId = R.drawable.image_drink_kong,
            description = "Modern bar with a futuristic design and high-quality signature cocktails.",
            address = "Piazza di S. Martino Ai Monti, 8, 00154 Roma RM, Italy",
            openingHours = "18:30 - 02:00",
            category = Category.bar
        ),
        Place(
            id = 20L,
            name = "Spirito",
            imageResourceId = R.drawable.image_spirito,
            description = "Hidden speakeasy-style bar serving inventive cocktails in a stylish setting.",
            address = "Via Fanfulla da Lodi, 53, 00176 Roma RM, Italy",
            openingHours = "20:00 - 02:00",
            category = Category.bar
        ),
        // Nightclubs
        Place(
            id = 21L,
            name = "Goa Club",
            imageResourceId = R.drawable.image_goa_club,
            description = "A popular nightclub known for electronic music and top DJs.",
            address = "Via Giuseppe Libetta, 13, 00154 Roma RM, Italy",
            openingHours = "23:00 - 04:00",
            category = Category.nightclub
        ),
        Place(
            id = 22L,
            name = "Shari Vari Playhouse",
            imageResourceId = R.drawable.image_shari_vari,
            description = "Stylish nightclub offering diverse music genres and a lively dance floor.",
            address = "Via di Torre Argentina, 78, 00186 Roma RM, Italy",
            openingHours = "23:00 - 04:00",
            category = Category.nightclub
        ),
        Place(
            id = 23L,
            name = "Art Café",
            imageResourceId = R.drawable.image_art_cafe,
            description = "Exclusive club attracting celebrities, known for its upscale vibe.",
            address = "Via del Galoppatoio, 33, 00197 Roma RM, Italy",
            openingHours = "23:30 - 04:30",
            category = Category.nightclub
        ),
        Place(
            id = 24L,
            name = "Qube",
            imageResourceId = R.drawable.image_qube,
            description = "Popular nightclub hosting Rome's famous LGBTQ+ party, Muccassassina.",
            address = "Via di Portonaccio, 212, 00159 Roma RM, Italy",
            openingHours = "22:30 - 04:00",
            category = Category.nightclub
        ),
        Place(
            id = 25L,
            name = "Piper Club",
            imageResourceId = R.drawable.image_piper_club,
            description = "Historic club known for its energetic atmosphere and eclectic music lineup.",
            address = "Via Tagliamento, 9, 00198 Roma RM, Italy",
            openingHours = "23:00 - 04:00",
            category = Category.nightclub
        )
    )
}