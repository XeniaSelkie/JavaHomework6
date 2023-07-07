import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Map<String, String>create_map; 
        System.out.println();
        Notebook note_1 = new Notebook("Huawei MateBook D 14 2021 NbD-WDH9", 8, 1024, "Windows 11", "серебристый");
        Notebook note_2 = new Notebook("Xiaomi RedmiBook 15 (JYU4525RU)", 8, 512, "Windows 11 Home", "синий");
        Notebook note_3 = new Notebook("Asus Laptop 15 X515JA-BQ2588", 16, 256, "DOS", "серебристый");
        Notebook note_4 = new Notebook("Xiaomi RedmiBook 15 (JYU4532RU)", 8, 512, "Windows 11 Home", "синий");
        Notebook note_5 = new Notebook("Lenovo IdeaPad 3 15IML05 (81WB0072RE)", 4, 1024, "Windows 11 Home", "черный");
    
        ArrayList<Notebook>noteList = new ArrayList<>();
        noteList.add(note_1);
        noteList.add(note_2);
        noteList.add(note_3);
        noteList.add(note_4);
        noteList.add(note_5);

        System.out.println("В наличии следующие ноутбуки: ---------------------------");
        for (var note : noteList) {
            System.out.println(note);
        }
        System.out.println();

        create_map = FindPar();
        FindList(create_map, noteList);

    }

   
    static void FindList(Map<String, String>create_map, ArrayList<Notebook>n_list) {
        ArrayList<Notebook>finalRes = new ArrayList<>();
        System.out.println();

        for (var note : n_list) {
            if ((create_map.containsKey("ram")) &&
                    (note.getRam() < Integer.parseInt(create_map.get("ram")))) {
                note.setName("");
            }
            if ((create_map.containsKey("hd")) &&
                    (note.getHd() < Integer.parseInt(create_map.get("hd")))) {
                note.setName("");
            }

            if ((create_map.containsKey("os")) &&
                    (!note.getOs().equals(create_map.get("os")))) {
                note.setName("");
            }
            if ((create_map.containsKey("colour")) &&
                    (!note.getColour().equals(create_map.get("colour")))) {
                note.setName("");
            }

        }
        
        for (var i : n_list) {
            if (!i.getName().equals("")) {
                finalRes.add(i);
            }
            System.out.println();
        }
        if (finalRes.size() > 0) {
            System.out.println();
            System.out.println("Выбранным характерстикам соответствуют: ");

            for (var item : finalRes) {
                System.out.println(item);
            }
            System.out.println();
        } else {
            System.out.println("Соответствий выбранным параметрам не найдено");
        }

    }

    static Map<String, String> FindPar() {
        String colour = "";
        String choice = "";
        String os = "";

        Boolean getOut = false;

        Map<String, String> str = new HashMap<>(); 
        Scanner scan = new Scanner(System.in);
        while (!getOut) {
            System.out.println();
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("Enter - вывод полученных результатов");

            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Введите минимальный объем ОЗУ в мегабайтах: ");
                    str.put("ram", scan.nextLine());
                    System.out.println("Выбрано: от " + str.get("ram") + " мегабайт ОЗУ");
                    break;
                }
                case "2": {
                    System.out.println("Введите минимальный объем диска в гигабайтах: ");
                    str.put("hd", scan.nextLine());
                    System.out.println("Выбрано: диск от " + str.get("hd") + " гигабайт");
                    System.out.println();
                    break;
                }
                case "3": {
                    System.out.println("Введите название операционной системы ");
                    System.out.println("Доступны следующие ОС:");
                    System.out.println("1 - Windows 11");
                    System.out.println("2 - Windows 11 Home");
                    System.out.println("3 - DOS");
                    System.out.println("Введите соответствующую цвету цифру: ");
                    choice = scan.nextLine();
                    switch (choice) {
                        case "1": {
                            os = "Windows 11";
                            break;
                        }
                        case "2": {
                            os = "Windows 11 Home";
                            break;
                        }
                        case "3": {
                            os = "DOS";
                            break;
                        }

                        default:
                            break;
                    }
                    str.put("os", os);
                    System.out.println("Выбрано: " + str.get("os"));
                    break;
                }
                case "4": {
                    System.out.println("Введите цвет ноутбука. ");
                    System.out.println("Доступны следующие цвета:");
                    System.out.println("1 - белый");
                    System.out.println("2 - серый");
                    System.out.println("3 - серебристый");
                    System.out.println("4 - черный");
                    System.out.println("5 - синий");
                    System.out.println("Введите соответствующую цвету цифру: ");
                    String colorNum = scan.nextLine();
                    switch (colorNum) {
                        case "1": {
                            colour = "белый";
                            break;
                        }
                        case "2": {
                            colour = "серый";
                            break;
                        }
                        case "3": {
                            colour = "серебристый";
                            break;
                        }
                        case "4": {
                            colour = "черный";
                            break;
                        }
                        case "5": {
                            colour = "синий";
                            break;
                        }
                        default:
                            break;
                    }
                    str.put("colour", colour);
                    System.out.println("Выбрано: " + str.get("colour"));
                    break;
                }
                case "": {
                    getOut = true;

                    System.out.println(str);
                    break;
                }
                default: {
                    System.out.println("Что-то пошло не так, попробуйте выбрать еще раз.");
                }
            }
        }
        System.out.println("Выбранные критерии поиска:");
        System.out.println(str);
        scan.close();
        return str;
    }
}