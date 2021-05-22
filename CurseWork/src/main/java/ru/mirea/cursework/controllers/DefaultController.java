package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mirea.cursework.entity.Post;
import ru.mirea.cursework.entity.Role;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repo.PostRepo;
import ru.mirea.cursework.repo.UserRepo;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class DefaultController {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;
    //Заполнить базу данных стандартными значениями
    @GetMapping("/setDefault")
    public String setDefault(){
        User admin=new User();
        admin.setRoles(Collections.singleton(Role.ADMIN));
        admin.setPassword("admin");
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        userRepo.save(admin);
        //postRepo.save(new Post("name","text","imgURl",(long)0,0.0,(long)0,new ArrayList<>()));
        postRepo.save(new Post("Пейнтбольный клуб Обитель зла","В распоряжении игроков 3 отличных игровых поля, зона отдыха вместимостью до 80 человек.\n" +
                "\n" +
                "Здесь есть детский пейнтбол. В него играют дети с 12 лет и старше.\n" +
                "\n" +
                "Также для группы предоставляется бесплатная зона отдыха на 1,5 часа после окончания игры. Еду и напитки можно принести с собой или заказать любую доставку.","obitel-zla.jpg",(long)0,0.0,(long)0,new ArrayList<>()));
        postRepo.save(new Post("Paintland","На территории расположены более десяти пейнтбольных площадок, спроектированных с учётом популярности сценариев игры и требований игровой аудитории.\n" +
                "Многие карты игр являются уникальными в своем роде, они являются лучшими в Москве и области.\n" +
                "\n" +
                "Предлагается самое современное снаряжение и средства защиты, а также имитационная пиротехника для игры в пейнтбол. Игру можно заказать в любое время года — клуб открыт для посещений круглогодично.","Paintland.jpeg",(long)0,0.0,(long)0,new ArrayList<>()));
        postRepo.save(new Post("Подземный клуб Лабиринт","В клубе оборудована крытая площадка для игры в пейнтбол. В любое время года вне зависимости от погоды здесь можно здорово провести время.\n" +
                "Площадь зоны для игры в пейнтбол составляет 1000 квадратных метров. На ней может комфортно играть до 20 человек.\n" +
                "\n" +
                "В стоимость билета включено: аренда защитного костюма, маски, маркера и неограниченное количество шаров. Время игры ограничено 2 часами.","labirint.jpg",(long)0,0.0,(long)0,new ArrayList<>()));
        postRepo.save(new Post("Тактический центр Контакт","Тактический центр «Контакт» находится практически в центре столицы. Сюда приглашают всех, кто желает получить незабываемые эмоции, приняв участие в боевой игре, действия которой происходят в городских условиях.\n" +
                "Во время игры используется пейнтбольное или страйкбольное оружие, стреляющее желатиновыми шарами. Участникам предлагаются самые различные виды снаряжения. Также участникам предоставляется специальная экипировка, обеспечивающая 100 процентную защиту.","kontakt.jpg",(long)0,0.0,(long)0,new ArrayList<>()));
        postRepo.save(new Post("Пейнтбольный клуб Северный Олень","В клубе имеется 2 карты: «Бастион» и «Стронгхолд», на которых можно сыграть множество интереснейших сценариев. Вместимость полей до 60 игроков. На площадках построены вышки, мостики, крепости.\n" +
                "Клуб – идеальное место для проведения Дня рождения, корпоратива, дружеских посиделок с шашлыками. Традиционно невысокие цены, грамотный и вежливый персонал, адаптированные детские сценарии то, что отличает клубы Московского Пейнтбольного Фронта.\n" +
                "\n" +
                "Зона отдыха клуба делится на платную и бесплатную. Бесплатно – размещение в общем зале, где для компании игроков выделяются столы и стулья по количеству игроков. Платно – отдельный зал. Стоимость от 6 до 20 тысяч в зависимости от необходимой площади.","severnyj-olen.jpg",(long)0,0.0,(long)0,new ArrayList<>()));
        postRepo.save(new Post("Пейнтбольный клуб МФП Водный Стадион","В перерыве между игрой можно отдохнуть в уютной зоне отдыха, подкрепиться, отметить победу или важное событие, например день рождения!\n" +
                "\n" +
                "Напитки и еду можно привезти с собой, а можно заказать в клубе (необходим предварительный заказ по меню и внесение предоплаты).\n" +
                "\n" +
                "Мангальная зона для приготовления шашлыков входит в стоимость сеанса и не требует дополнительной оплаты при игре по тарифу «Все включено».","vodnyj-stan.jpg",(long)0,0.0,(long)0,new ArrayList<>()));
        return "redirect:/";
    }
}
