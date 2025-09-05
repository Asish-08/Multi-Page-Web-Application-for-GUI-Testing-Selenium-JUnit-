function goToPage(page) {
  window.location.href = page;
}

function addToFavorites(petName) {
  const favorites = JSON.parse(localStorage.getItem('favorites')) || [];
  if (!favorites.includes(petName)) {
    favorites.push(petName);
    localStorage.setItem('favorites', JSON.stringify(favorites));
    alert(`${petName} added to favorites!`);
  } else {
    alert(`${petName} is already in your favorites.`);
  }
}
