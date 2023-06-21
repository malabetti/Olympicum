package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void cadastrar_olimpiada(Scanner scanner){
        File file_olimpiadas = new File("olimpiadas.txt");

        System.out.println("\nCadastro de olimpíada:");
        System.out.println("--Olimpíada");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sigla: ");
        String sigla = scanner.nextLine();
        System.out.print("Tema: ");
        String tema = scanner.nextLine();
        System.out.println("--Coordenador");
        System.out.print("Nome: ");
        String coord = scanner.nextLine();
        System.out.print("Usuário: ");
        String user = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter(file_olimpiadas, true);
            writer.write(nome + "," + sigla + "," + tema + "," + coord + "," +  user + "," + senha);
            System.out.println("\nOlimpíada cadastrada com sucesso!");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("\nErro ao cadastrar olimpíada!");
        }
    }

    static void acessar_olimpiada (Scanner scanner) {
        File file_olimpiadas = new File("olimpiadas.txt");
        try {
            FileReader reader = new FileReader(file_olimpiadas);
            BufferedReader bufferedReader = new BufferedReader(reader);
            ArrayList olimpiadas = new ArrayList();
            String linha;
            int i = 1;
            while ((linha = bufferedReader.readLine()) != null) {
                String olimpiada[] = linha.split(",");
                System.out.println(i +" - " + olimpiada[0]);
                olimpiadas.add(linha);
                i++;
            }
            System.out.println("Digite o número da olimpíada que deseja: ");
            int num = Integer.parseInt(scanner.nextLine());
            String s[] = olimpiadas.get(i).toString().split(",");
            String o = s[0];
            acessar(o);
        }
        catch (IOException e) {
            System.out.println("\nErro ao abrir o arquivo!");
        }
    }

    static void acessar(String op){

    }

    static void menu1 (Scanner scanner) {
        while (true) {
            System.out.println("\n-----Menu-----");
            System.out.print("1 - Acessar Olimpíada\n2 - Cadastrar Olimpíada\n3 - Sair\n-> ");
            int opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1 -> {
                    File file_olimpiadas = new File("olimpiadas.txt");
                    if (file_olimpiadas.exists()) {
                        acessar_olimpiada(scanner);
                    }
                    else {
                        System.out.println("\nNão há olimpíadas cadastradas!");
                    }
                }
                case 2 -> {
                    cadastrar_olimpiada(scanner);
                }
                case 3 -> {
                    System.out.println("\nSaindo!");
                }
                default -> {
                    System.out.println("\nOpção inválida!");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu1(scanner);
    }
}