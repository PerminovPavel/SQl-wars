import java.sql.SQLException;

public class db {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conn.Conn();
        conn.CreateDB();
        conn.createDBCats();
        //conn.insert_type("Простая кошка");
        //conn.insert_type("INSERT INTO 'types' ('type') VALUES ('Австралийский мист');");
        //conn.insert_type("INSERT INTO 'types' ('type') VALUES ('Американская жесткошерстная');");
        //conn.WriteDB();
        //conn.ReadDB();
        //conn.CloseDB();
        //conn.delete("delete from 'types' where id > 0");
        //conn.insertDB();
        //conn.delete_type(61);
        //conn.update_type(1, "Дворовая простая");
        //conn.get_type(1);
        //conn.get_type_where("type LIKE 'А%'");
        //conn.get_all_types();
        conn.insert_cat("Кисуля", "Дворовая очень непушистая", 6, 3.5);
        //conn.getType("Дворовая простая");
        //conn.CloseDB();


    }
}