

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class conn {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;





    public conn() throws FileNotFoundException {
    }

    public static void Conn() throws ClassNotFoundException, SQLException {

            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

            System.out.println("База Подключена!");
        }

    public static void CreateDB() throws SQLException {
        {
            statmt = conn.createStatement();
            statmt.execute("CREATE TABLE if not exists 'cats' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'type' text not null);");

            System.out.println("Таблица 'types' создана или уже существует.");
        }
    }

    public static void WriteDB() throws SQLException
    {
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");

        System.out.println("Таблица заполнена");
    }
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  phone = resSet.getString("phone");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "phone = " + phone );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }

    public static void insert_type(String inString) throws SQLException {
        statmt.execute("INSERT INTO 'types' ('type') VALUES ('"+inString+"');");

    }

    public static void delete (String inString) throws SQLException {
        statmt.execute(inString);
    }

    public static void InsertDB() {
        String[] types1 = new String[]{"Абиссинская кошка", "Австралийский мист", "Американская жесткошерстная", "Американская короткошерстная", "Американский бобтейл", "Американский кёрл", "Балинезийская кошка", "Бенгальская кошка", "Бирманская кошка", "Бомбейская кошка", "Бразильская короткошёрстная", "Британская длинношерстная", "Британская короткошерстная", "Бурманская кошка", "Бурмилла кошка", "Гавана", "Гималайская кошка", "Девон-рекс", "Донской сфинкс", "Европейская короткошерстная", "Египетская мау", "Канадский сфинкс", "Кимрик", "Корат", "Корниш-рекс", "Курильский бобтейл", "Лаперм", "Манчкин", "Мейн-ку́н", "Меконгский бобтейл", "Мэнкс кошка", "Наполеон", "Немецкий рекс", "Нибелунг", "Норвежская лесная кошка", "Ориентальная кошка", "Оцикет", "Персидская кошка", "Петерболд", "Пиксибоб", "Рагамаффин", "Русская голубая кошка", "Рэгдолл", "Саванна", "Селкирк-рекс", "Сиамская кошка", "Сибирская кошка",
                "Сингапурская кошка", "Скоттиш-фолд", "Сноу-шу", "Сомалийская кошка", "Тайская кошка", "Тойгер", "Тонкинская кошка", "Турецкая ангорская кошка", "Турецкий ван", "Украинский левкой", "Чаузи", "Шартрез", "Экзотическая короткошерстная", "Японский бобтейл"};

    for (String s : types1) {
        System.out.println(s);
    }


}

    public static void insertDB() throws SQLException {
        String[] types = new String[]{"Абиссинская кошка", "Австралийский мист", "Американская жесткошерстная", "Американская короткошерстная", "Американский бобтейл", "Американский кёрл", "Балинезийская кошка", "Бенгальская кошка", "Бирманская кошка", "Бомбейская кошка", "Бразильская короткошёрстная", "Британская длинношерстная", "Британская короткошерстная", "Бурманская кошка", "Бурмилла кошка", "Гавана", "Гималайская кошка", "Девон-рекс", "Донской сфинкс", "Европейская короткошерстная", "Египетская мау", "Канадский сфинкс", "Кимрик", "Корат", "Корниш-рекс", "Курильский бобтейл", "Лаперм", "Манчкин", "Мейн-ку́н", "Меконгский бобтейл", "Мэнкс кошка", "Наполеон", "Немецкий рекс", "Нибелунг", "Норвежская лесная кошка", "Ориентальная кошка", "Оцикет", "Персидская кошка", "Петерболд", "Пиксибоб", "Рагамаффин", "Русская голубая кошка", "Рэгдолл", "Саванна", "Селкирк-рекс", "Сиамская кошка", "Сибирская кошка",
                "Сингапурская кошка", "Скоттиш-фолд", "Сноу-шу", "Сомалийская кошка", "Тайская кошка", "Тойгер", "Тонкинская кошка", "Турецкая ангорская кошка", "Турецкий ван", "Украинский левкой", "Чаузи", "Шартрез", "Экзотическая короткошерстная", "Японский бобтейл"};

        for (String s : types) {
            statmt.execute("INSERT INTO types (type) VALUES ('" + s + "')");
        }
        System.out.println("Данные добавлены");
    }


    public static void delete_type(int i) throws SQLException {

        String deleteid = "delete from 'types' where id = " + i;

        statmt.execute(deleteid);
        System.out.println("Данные с id " +i+" удалены!");
    }

    public static void update_type(int i, String newtype) throws SQLException {

        String update = "update 'types' set type = ('" + newtype + "') where id = " + i;

        statmt.execute(update);
        System.out.println("Данные с id " +i+" изменены на " + newtype);
    }

    public static void get_type(int i) throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM types where id = " + i);

        String  type = resSet.getString("type");



            System.out.println(i + " индекс: " + type);




    }

    public static void get_type_where(String s) throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM types where " + s);

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  type = resSet.getString("type");

            System.out.println( "ID = " + id );
            System.out.println( "type = " + type );

            System.out.println();
        }


    }

    public static void get_all_types() throws SQLException {

        resSet = statmt.executeQuery("SELECT * FROM types");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String type = resSet.getString("type");

            System.out.println( "ID = " + id );
            System.out.println( "type = " + type );

            System.out.println();
        }
    }

    public static void createDBCats() throws SQLException {
        {
            statmt = conn.createStatement();
            statmt.execute("CREATE TABLE if not exists cats (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20) NOT NULL, type_id INTEGER NOT NULL, age INTEGER NOT NULL, weight DOUBLE," +
                    "FOREIGN KEY(type_id) REFERENCES types (id))");

            System.out.println("Таблица 'cats' создана или уже существует.");
        }
    }

    public static void insert_cat(String name, String type, int age, Double weight) throws SQLException {



        resSet = statmt.executeQuery("SELECT * FROM types");
        boolean isTypeIn = false;

        while(resSet.next())
        {
            {
                String type1 = resSet.getString("type");
                if(type.equals(type1)) isTypeIn = true;
            }

        }

        if (!isTypeIn) {
            insert_type(type);
            int id = getType(type);

            statmt.execute("INSERT INTO 'cats' ('name','type_id','age','weight') " +
                    "VALUES ('" + name + "'," + id + "," + age + "," + weight + ")");

        } else {

            int id = getType(type);
            statmt.execute("INSERT INTO 'cats' ('name','type_id','age','weight') " +
                    "VALUES ('" + name + "'," + id + "," + age + "," + weight + ")");
        }


        System.out.println(isTypeIn?"Добавлена только кошка":"Породы "+ type +" еще не было!");
    }



    public static int getType(String s) throws SQLException {
        resSet = statmt.executeQuery("SELECT id FROM types where type = '" + s + "'");

        int id = resSet.getInt("id");

        return id;


    }


}





