// Dummy data for testing, replace with actual data from your backend
const dummyRealTimeWeatherData = [
    { city: 'City1', temperature: 25, condition: 'Sunny' },
    { city: 'City2', temperature: 18, condition: 'Cloudy' },
    { city: 'City3', temperature: 15, condition: 'Rainy' },
];

const dummyHourlyForecastData = [
    { time: '12:00 PM', temperature: 28, condition: 'Sunny' },
    { time: '3:00 PM', temperature: 30, condition: 'Clear' },
    { time: '6:00 PM', temperature: 25, condition: 'Cloudy' },
];

// Function to display weather data on the page
function displayRealTimeWeatherData(weatherData) {
    const weatherContainer = document.getElementById('weather-container');
    weatherContainer.innerHTML = '';

    weatherData.forEach(data => {
        const card = document.createElement('div');
        card.className = 'weather-card';
        card.innerHTML = `
            <h3>${data.city}</h3>
            <p>Temperature: ${data.temperature}°C</p>
            <p>Condition: ${data.condition}</p>
        `;
        weatherContainer.appendChild(card);
    });
}

// Function to display hourly forecast data on the page
function displayHourlyForecastData(forecastData) {
    const forecastContainer = document.getElementById('hourly-forecast-container');
    forecastContainer.innerHTML = '';

    forecastData.forEach(data => {
        const card = document.createElement('div');
        card.className = 'forecast-card';
        card.innerHTML = `
            <p>Time: ${data.time}</p>
            <p>Temperature: ${data.temperature}°C</p>
            <p>Condition: ${data.condition}</p>
        `;
        forecastContainer.appendChild(card);
    });
}

// Function to update the dynamic clock
function updateClock() {
    const clockElement = document.getElementById('clock');
    const currentTime = new Date();
    const hours = currentTime.getHours();
    const minutes = currentTime.getMinutes();
    const seconds = currentTime.getSeconds();
    const formattedTime = `${hours}:${minutes < 10 ? '0' + minutes : minutes}:${seconds < 10 ? '0' + seconds : seconds}`;
    clockElement.textContent = formattedTime;
}

// Call the displayRealTimeWeatherData and displayHourlyForecastData functions with dummy data
displayRealTimeWeatherData(dummyRealTimeWeatherData);
displayHourlyForecastData(dummyHourlyForecastData);

// Update the clock every second
setInterval(updateClock, 1000);
