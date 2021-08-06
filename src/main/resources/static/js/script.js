$(document).ready(function() {

    const menu = document.querySelector('.header__menu'),
        menuItem = document.querySelectorAll('.header__menu-item'),
        hamburger = document.querySelector('.hamburger');

    hamburger.addEventListener('click', () => {
        hamburger.classList.toggle('hamburger-active');
        menu.classList.toggle('header__menu-active');
    });

    menuItem.forEach(item => {
        item.addEventListener('click', () => {
            hamburger.classList.toggle('hamburger-active');
            menu.classList.toggle('header__menu-active');
        })
    })

function selectContent(evt, cityName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("page__tab-tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

    let fuelUrbanCycle = document.getElementById('fuelUrbanCycle').innerHTML;
    let fuelHigwayCycle = document.getElementById('fuelHigwayCycle').innerHTML;
    let fuelMixedCycle = document.getElementById('fuelMixedCycle').innerHTML;
    let fuelUrbanCyclePrice = document.getElementById('fuelUrbanCyclePrice').innerHTML;
    let fuelHigwayCyclePrice = document.getElementById('fuelHigwayCyclePrice').innerHTML;
    let fuelMixedCyclePrice = document.getElementById('fuelMixedCyclePrice').innerHTML;
    let horsePowerPrice = document.getElementById('horsePowerPrice').innerHTML;
    let fuelMixedCyclePriceYear = document.getElementById('fuelMixedCyclePriceYear').innerHTML;
    let costsPerYear = document.getElementById('costsPerYear').innerHTML;

    let myChart = document.getElementById('myChart').getContext('2d');
    let myChart2 = document.getElementById('myChart2').getContext('2d');
    let myChart3 = document.getElementById('myChart3').getContext('2d');
    let massPopChart = new Chart(myChart,{
        type: 'bar',
        data:{
            labels:['Расходы в городском режиме','Расход на трассе','Расход в смешанном режиме'],
            datasets:[{
                label: 'Расходы',
                data:[
                    fuelUrbanCycle,
                    fuelHigwayCycle,
                    fuelMixedCycle,
                ],
                backgroundColor: [
                    'rgba(54,162,235,0.6)',
                    'rgba(255,206,86,0.6)',
                    'rgba(255,99,132,0.6)',
                ],
                borderWith: 3,
                borderColor: '#777',
                hoverBorderWidth:3,
                hoverBorderColor:'#000'
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Круг расходов за год',
                fontSize: 25,
                color: '#777'
            }
        }
    });
    let massPopChart2 = new Chart(myChart2,{
        type: 'bar',
        data:{
            labels:['Расходы в городском режиме','Расход на трассе','Расход в смешанном режиме'],
            datasets:[{
                label: 'Расходы',
                data:[
                    fuelUrbanCycle,
                    fuelHigwayCycle,
                    fuelMixedCycle,
                ],
                backgroundColor: [
                    'rgba(54,162,235,0.6)',
                    'rgba(255,206,86,0.6)',
                    'rgba(255,99,132,0.6)',
                ],
                borderWith: 3,
                borderColor: '#777',
                hoverBorderWidth:3,
                hoverBorderColor:'#000'
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Круг расходов за год',
                fontSize: 25,
                color: '#777'
            }
        }
    });
    let massPopChart3 = new Chart(myChart3,{
        type: 'pie',
        data:{
            labels:['Бензин','Налог','Обслуживание'],
            datasets:[{
                label: 'Population',
                data:[
                    fuelMixedCyclePriceYear,
                    horsePowerPrice,
                    costsPerYear,
                ],
                backgroundColor: [
                    'rgba(54,162,235,0.6)',
                    'rgba(255,206,86,0.6)',
                    'rgba(255,99,132,0.6)',
                ],
                borderWith: 3,
                borderColor: '#777',
                hoverBorderWidth:3,
                hoverBorderColor:'#000'
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Круг расходов за год',
                fontSize: 25,
                color: '#777'
            }
        }
    });


})
