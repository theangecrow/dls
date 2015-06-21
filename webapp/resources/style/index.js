function One()
{
  document.getElementById('OneTab').className = 'SelectedTab';
  document.getElementById('TwoTab').className = 'Tab';
  document.getElementById('ThreeTab').className = 'Tab';

  document.getElementById('One').style.display = 'block';
  document.getElementById('Two').style.display = 'none';
  document.getElementById('Three').style.display = 'none';
 
}
function Two()
{
  document.getElementById('OneTab').className = 'Tab';
  document.getElementById('TwoTab').className = 'SelectedTab';
  document.getElementById('ThreeTab').className = 'Tab';
 
  document.getElementById('One').style.display = 'none';
  document.getElementById('Two').style.display = 'block';
  document.getElementById('Three').style.display = 'none';
 
}

function Three()
{
    document.getElementById('OneTab').className = 'Tab';
    document.getElementById('TwoTab').className = 'Tab';
    document.getElementById('ThreeTab').className = 'SelectedTab';

    document.getElementById('One').style.display = 'none';
    document.getElementById('Two').style.display = 'none';
    document.getElementById('Three').style.display = 'block';
}
