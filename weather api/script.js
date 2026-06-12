async function getWeather(){

    const city =
    document.getElementById("city").value.trim();

    if(city === ""){

        alert("Please enter a city name");
        return;
    }

    const apiKey =
    "22ea40aadc5c587401480d173cf1b70a";

    const url =
    `https://api.openweathermap.org/data/2.5/forecast?q=${city}&appid=${apiKey}&units=metric`;

    try{

        const response =
        await fetch(url);

        const data =
        await response.json();

        if(data.cod !== "200"){

            alert("City not found");
            return;
        }

        const table =
        document.querySelector("#weatherTable tbody");

        table.innerHTML = "";

        let displayedDates = [];

        data.list.forEach(item => {

            let date =
            item.dt_txt.split(" ")[0];

            let time =
            item.dt_txt.split(" ")[1];

            if(
                time === "12:00:00" &&
                displayedDates.length < 5
            ){

                displayedDates.push(date);

                table.innerHTML += `

                <tr>

                    <td>${date}</td>

                    <td>${time}</td>

                    <td>${item.main.temp} °C</td>

                    <td>${item.weather[0].description}</td>

                </tr>

                `;
            }

        });

    }
    catch(error){

        console.log(error);

        alert("Error fetching weather data");
    }
}