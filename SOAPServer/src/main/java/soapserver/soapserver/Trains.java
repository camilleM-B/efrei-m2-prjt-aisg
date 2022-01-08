package soapserver.soapserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Trains {
    private Train[] trains;

    public Trains() {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            trains = objectMapper.readValue(json, Train[].class);
            for(Train train : trains) {
                out.println(train);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Train[] getArray() {
        return trains;
    }

    String json = "[\n" +
            "  {\n" +
            "    \"id\": \"ced6a97a-00e1-579e-bafd-ad3d074577b7\",\n" +
            "    \"departureStation\": \"Fumdicti\",\n" +
            "    \"arrivalStation\": \"Deseka\",\n" +
            "    \"outboundDate\": \"2022-03-14T11:15:01+01:00\",\n" +
            "    \"returnDate\": \"2022-03-14T18:15:01+01:00\",\n" +
            "    \"totalTickets\": 240,\n" +
            "    \"remainingTickets\": 10,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 107\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"145f9e70-c531-5d59-93f3-468a208926d4\",\n" +
            "    \"departureStation\": \"Bumvavo\",\n" +
            "    \"arrivalStation\": \"Jomosav\",\n" +
            "    \"outboundDate\": \"2022-04-26T18:35:55+01:00\",\n" +
            "    \"returnDate\": \"2022-04-26T21:31:08+01:00\",\n" +
            "    \"totalTickets\": 254,\n" +
            "    \"remainingTickets\": 45,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 159\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"3255bdf6-97da-51e3-b2b4-6a1837532ab1\",\n" +
            "    \"departureStation\": \"Povfuslu\",\n" +
            "    \"arrivalStation\": \"Paboce\",\n" +
            "    \"outboundDate\": \"2022-02-10T10:25:08+01:00\",\n" +
            "    \"returnDate\": \"2022-02-10T16:36:52+01:00\",\n" +
            "    \"totalTickets\": 192,\n" +
            "    \"remainingTickets\": 25,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 138\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"ac963153-096f-5ce4-9e0e-81a1de068f63\",\n" +
            "    \"departureStation\": \"Kohvodcu\",\n" +
            "    \"arrivalStation\": \"Evegafe\",\n" +
            "    \"outboundDate\": \"2022-07-08T02:01:04+01:00\",\n" +
            "    \"returnDate\": \"2022-07-08T08:04:47+01:00\",\n" +
            "    \"totalTickets\": 269,\n" +
            "    \"remainingTickets\": 35,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 74\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"6263f520-f09d-5eaa-82a1-f2102fde105e\",\n" +
            "    \"departureStation\": \"Docomnij\",\n" +
            "    \"arrivalStation\": \"Butzemer\",\n" +
            "    \"outboundDate\": \"2022-07-10T02:58:46+01:00\",\n" +
            "    \"returnDate\": \"2022-07-10T04:02:04+01:00\",\n" +
            "    \"totalTickets\": 199,\n" +
            "    \"remainingTickets\": 28,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 154\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"7d903e53-3af8-5d93-9195-5e59ea2d9d79\",\n" +
            "    \"departureStation\": \"Jefejaha\",\n" +
            "    \"arrivalStation\": \"Cidiris\",\n" +
            "    \"outboundDate\": \"2022-11-11T15:53:19+01:00\",\n" +
            "    \"returnDate\": \"2022-11-11T18:59:20+01:00\",\n" +
            "    \"totalTickets\": 260,\n" +
            "    \"remainingTickets\": 16,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 88\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"b8265c4c-fce8-5d8e-8c32-d49c1076db29\",\n" +
            "    \"departureStation\": \"Ludcarwo\",\n" +
            "    \"arrivalStation\": \"Zapbaduh\",\n" +
            "    \"outboundDate\": \"2022-12-21T06:00:26+01:00\",\n" +
            "    \"returnDate\": \"2022-12-21T09:05:15+01:00\",\n" +
            "    \"totalTickets\": 104,\n" +
            "    \"remainingTickets\": 14,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 22\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"d4f3ffab-10b1-52c7-9421-c13d47615d52\",\n" +
            "    \"departureStation\": \"Kusospa\",\n" +
            "    \"arrivalStation\": \"Rapawgi\",\n" +
            "    \"outboundDate\": \"2022-11-04T00:20:13+01:00\",\n" +
            "    \"returnDate\": \"2022-11-04T03:22:53+01:00\",\n" +
            "    \"totalTickets\": 191,\n" +
            "    \"remainingTickets\": 37,\n" +
            "    \"travelClass\": \"first\",\n" +
            "    \"price\": 42\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"c19d1662-08b6-5101-ab75-ecb03be5d69f\",\n" +
            "    \"departureStation\": \"Fawtocolu\",\n" +
            "    \"arrivalStation\": \"Tunalle\",\n" +
            "    \"outboundDate\": \"2022-05-26T11:54:53+01:00\",\n" +
            "    \"returnDate\": \"2022-05-26T18:22:13+01:00\",\n" +
            "    \"totalTickets\": 341,\n" +
            "    \"remainingTickets\": 33,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 49\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"a9b8fa01-0f47-5ce1-b65c-dae47cd8591f\",\n" +
            "    \"departureStation\": \"Topawif\",\n" +
            "    \"arrivalStation\": \"Ekpudciw\",\n" +
            "    \"outboundDate\": \"2022-12-06T11:49:59+01:00\",\n" +
            "    \"returnDate\": \"2022-12-06T21:43:37+01:00\",\n" +
            "    \"totalTickets\": 307,\n" +
            "    \"remainingTickets\": 1,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 95\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"3577ea45-ab55-51fd-848b-f4fecc36d37f\",\n" +
            "    \"departureStation\": \"Lokewji\",\n" +
            "    \"arrivalStation\": \"Owezuzo\",\n" +
            "    \"outboundDate\": \"2022-11-04T10:24:00+01:00\",\n" +
            "    \"returnDate\": \"2022-11-04T12:11:31+01:00\",\n" +
            "    \"totalTickets\": 167,\n" +
            "    \"remainingTickets\": 43,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 70\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"4f5a5150-c4c5-5e33-bb8d-83d9b73aa3fd\",\n" +
            "    \"departureStation\": \"Sewnosid\",\n" +
            "    \"arrivalStation\": \"Mebrokal\",\n" +
            "    \"outboundDate\": \"2022-06-28T12:43:19+01:00\",\n" +
            "    \"returnDate\": \"2022-06-28T13:43:11+01:00\",\n" +
            "    \"totalTickets\": 371,\n" +
            "    \"remainingTickets\": 50,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 100\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"f76f5349-d128-5d8b-b5f8-e00bb50fc884\",\n" +
            "    \"departureStation\": \"Abpewkem\",\n" +
            "    \"arrivalStation\": \"Luvepo\",\n" +
            "    \"outboundDate\": \"2022-05-21T17:24:08+01:00\",\n" +
            "    \"returnDate\": \"2022-05-21T18:58:11+01:00\",\n" +
            "    \"totalTickets\": 230,\n" +
            "    \"remainingTickets\": 41,\n" +
            "    \"travelClass\": \"first\",\n" +
            "    \"price\": 182\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"e52dd941-d319-5c76-8fd4-e791785af013\",\n" +
            "    \"departureStation\": \"Sowkoki\",\n" +
            "    \"arrivalStation\": \"Wiizta\",\n" +
            "    \"outboundDate\": \"2022-06-06T08:11:22+01:00\",\n" +
            "    \"returnDate\": \"2022-06-06T10:39:07+01:00\",\n" +
            "    \"totalTickets\": 354,\n" +
            "    \"remainingTickets\": 19,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 25\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"29195425-cb0e-5bfa-9703-96c8ac901b63\",\n" +
            "    \"departureStation\": \"Isrewvuj\",\n" +
            "    \"arrivalStation\": \"Ohrowveg\",\n" +
            "    \"outboundDate\": \"2022-03-28T05:50:57+01:00\",\n" +
            "    \"returnDate\": \"2022-03-28T07:24:20+01:00\",\n" +
            "    \"totalTickets\": 355,\n" +
            "    \"remainingTickets\": 34,\n" +
            "    \"travelClass\": \"first\",\n" +
            "    \"price\": 122\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"0e0b9af4-35a9-574d-9cf5-eba3ea986100\",\n" +
            "    \"departureStation\": \"Sedukobok\",\n" +
            "    \"arrivalStation\": \"Uwegosit\",\n" +
            "    \"outboundDate\": \"2022-05-10T05:19:53+01:00\",\n" +
            "    \"returnDate\": \"2022-05-10T09:58:06+01:00\",\n" +
            "    \"totalTickets\": 310,\n" +
            "    \"remainingTickets\": 17,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 87\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"fa9d3071-6224-5185-acb2-86690f684a7f\",\n" +
            "    \"departureStation\": \"Wenkejbic\",\n" +
            "    \"arrivalStation\": \"Uvofte\",\n" +
            "    \"outboundDate\": \"2022-07-30T20:51:32+01:00\",\n" +
            "    \"returnDate\": \"2022-07-30T21:02:00+01:00\",\n" +
            "    \"totalTickets\": 186,\n" +
            "    \"remainingTickets\": 20,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 31\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"a4b8151a-205e-5574-b9b0-de4bc790e9c6\",\n" +
            "    \"departureStation\": \"Tifmara\",\n" +
            "    \"arrivalStation\": \"Ranadzaw\",\n" +
            "    \"outboundDate\": \"2022-06-13T14:07:09+01:00\",\n" +
            "    \"returnDate\": \"2022-06-13T23:27:25+01:00\",\n" +
            "    \"totalTickets\": 285,\n" +
            "    \"remainingTickets\": 34,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 105\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"da1f66cc-b5d6-538c-9d0a-e15fd84784d6\",\n" +
            "    \"departureStation\": \"Mionujuf\",\n" +
            "    \"arrivalStation\": \"Bejufwud\",\n" +
            "    \"outboundDate\": \"2022-04-28T10:01:54+01:00\",\n" +
            "    \"returnDate\": \"2022-04-28T11:16:25+01:00\",\n" +
            "    \"totalTickets\": 285,\n" +
            "    \"remainingTickets\": 29,\n" +
            "    \"travelClass\": \"first\",\n" +
            "    \"price\": 37\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"11b22a22-c3ce-548b-91ad-da920fcd845b\",\n" +
            "    \"departureStation\": \"Cagalhik\",\n" +
            "    \"arrivalStation\": \"Alapikme\",\n" +
            "    \"outboundDate\": \"2022-07-11T10:25:47+01:00\",\n" +
            "    \"returnDate\": \"2022-07-11T13:57:07+01:00\",\n" +
            "    \"totalTickets\": 106,\n" +
            "    \"remainingTickets\": 9,\n" +
            "    \"travelClass\": \"first\",\n" +
            "    \"price\": 150\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"6323b549-ad6f-55b5-81bb-2261e6217b56\",\n" +
            "    \"departureStation\": \"Cudpuhit\",\n" +
            "    \"arrivalStation\": \"Pipiwsug\",\n" +
            "    \"outboundDate\": \"2022-12-28T10:55:17+01:00\",\n" +
            "    \"returnDate\": \"2022-12-28T13:33:50+01:00\",\n" +
            "    \"totalTickets\": 275,\n" +
            "    \"remainingTickets\": 39,\n" +
            "    \"travelClass\": \"first\",\n" +
            "    \"price\": 152\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"9c739de7-cd70-5893-8493-305009e7da63\",\n" +
            "    \"departureStation\": \"Ipiinej\",\n" +
            "    \"arrivalStation\": \"Hewipjuf\",\n" +
            "    \"outboundDate\": \"2022-05-29T16:09:07+01:00\",\n" +
            "    \"returnDate\": \"2022-05-29T17:49:24+01:00\",\n" +
            "    \"totalTickets\": 382,\n" +
            "    \"remainingTickets\": 20,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 39\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"02e37299-0895-5218-a709-57ebeb6b0d1a\",\n" +
            "    \"departureStation\": \"Doshapu\",\n" +
            "    \"arrivalStation\": \"Zutemagub\",\n" +
            "    \"outboundDate\": \"2022-09-20T21:10:25+01:00\",\n" +
            "    \"returnDate\": \"2022-09-20T22:34:16+01:00\",\n" +
            "    \"totalTickets\": 361,\n" +
            "    \"remainingTickets\": 17,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 182\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"f3f67155-a224-53aa-a173-111341410177\",\n" +
            "    \"departureStation\": \"Amigoda\",\n" +
            "    \"arrivalStation\": \"Derujla\",\n" +
            "    \"outboundDate\": \"2022-04-19T12:54:29+01:00\",\n" +
            "    \"returnDate\": \"2022-04-19T15:05:24+01:00\",\n" +
            "    \"totalTickets\": 198,\n" +
            "    \"remainingTickets\": 26,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 190\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"ac9186b6-5281-5956-b450-9898793fe033\",\n" +
            "    \"departureStation\": \"Zovukop\",\n" +
            "    \"arrivalStation\": \"Copedome\",\n" +
            "    \"outboundDate\": \"2022-05-15T15:45:07+01:00\",\n" +
            "    \"returnDate\": \"2022-05-15T17:49:58+01:00\",\n" +
            "    \"totalTickets\": 153,\n" +
            "    \"remainingTickets\": 40,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 151\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"f66c4429-64b8-5e93-b76f-102392e3e851\",\n" +
            "    \"departureStation\": \"Digfuta\",\n" +
            "    \"arrivalStation\": \"Serimas\",\n" +
            "    \"outboundDate\": \"2022-07-05T01:47:57+01:00\",\n" +
            "    \"returnDate\": \"2022-07-05T02:26:56+01:00\",\n" +
            "    \"totalTickets\": 294,\n" +
            "    \"remainingTickets\": 37,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 49\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"0b5954e3-a291-512c-a6b8-e54342b4117d\",\n" +
            "    \"departureStation\": \"Japfawe\",\n" +
            "    \"arrivalStation\": \"Eripedfal\",\n" +
            "    \"outboundDate\": \"2022-08-25T05:32:28+01:00\",\n" +
            "    \"returnDate\": \"2022-08-25T07:31:21+01:00\",\n" +
            "    \"totalTickets\": 166,\n" +
            "    \"remainingTickets\": 24,\n" +
            "    \"travelClass\": \"business\",\n" +
            "    \"price\": 48\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"56786e49-2a0f-57ba-a36e-398127d24bf0\",\n" +
            "    \"departureStation\": \"Wowfowup\",\n" +
            "    \"arrivalStation\": \"Ikolijupe\",\n" +
            "    \"outboundDate\": \"2022-05-11T15:16:03+01:00\",\n" +
            "    \"returnDate\": \"2022-05-11T17:06:33+01:00\",\n" +
            "    \"totalTickets\": 187,\n" +
            "    \"remainingTickets\": 35,\n" +
            "    \"travelClass\": \"standard\",\n" +
            "    \"price\": 72\n" +
            "  }\n" +
            "]\n" +
            "\n";
}
