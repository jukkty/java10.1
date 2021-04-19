package ru.netology.manager;

import ru.netology.domain.Movies;

public class MovieManager {
  private Movies[] movies = new Movies[0];

  public void add(Movies movie) {
    int length = movies.length + 1;
    Movies[] tmp = new Movies[length];
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = movie;
    movies = tmp;
  }

  public Movies[] getAll() {
    Movies[] result = new Movies[movies.length];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    if (movies.length > 10)
      result = new Movies[10];
    for (int i = 0; i < result.length; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }

  public Movies[] getExactNumberOfMovies(int quantity) {
    Movies[] result = new Movies[movies.length];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    if (movies.length>quantity)
      result = new Movies[quantity];
    for (int i = 0; i < result.length; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }
}
