package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    public static final List<MealWithExceed> MEALS = Arrays.asList(
            new MealWithExceed(LocalDateTime.of(2015, Month.MAY, 30, 15, 0), "Обед", 11100, true),
            new MealWithExceed(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 100, false));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("getAll");
        request.setAttribute("list", MEALS);
        request.getRequestDispatcher("meals.jsp").forward(request, response);

    }
}
