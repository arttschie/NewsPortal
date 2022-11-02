package org.nogin.service;

import org.nogin.models.News;
import org.nogin.models.User;

import java.util.List;

public interface UserService {
  List<User> getUsers();
  User getUserByNews(News news);
  User getById(Long id);
  User getByLogin(String login);
  User getByPassword(String password);
  void createUser();
  User changeUserLogin(User user, String login);
  User changeUserPassword(User user, String password);
}
