package com.qinguangfeng.entity812;

import java.io.File;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class DealXml {
	// �� �ĵ����� ����Ϊ ȫ�ֱ���������� ���췽�� ���������� ����������
	private Document document;
	private Scanner s = new Scanner(System.in);

	// �ȸ�� ���췽��
	public DealXml() throws Exception {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		// ��ȡ���ڵ�
		document = documentBuilder.parse("src/com/qinguangfeng/entity812/Two_Score.xml");
	}

	public List selectAll(){
		System.out.println("���\t����\t��Ŀ\t����");
		// ��ȡ ��ǩ���� student
		NodeList nodeList = document.getElementsByTagName("student");
		List<StuLeiJson> returnValue=new ArrayList<StuLeiJson>();
		
		// ѭ�� ��� ���Ա�ǩ���� ������ �ڵ�
		System.out.println("--------------------------------");
		for (int i = 0; i < nodeList.getLength(); i++) {
			// ��ȡ��I���ڵ�
			Element element = (Element) nodeList.item(i);
			// ��ȡ�� ��ǩ ������
			String id = element.getAttribute("id");
			// ��ȡ��I���ڵ� �ĵ�I�� �ı�����
			String name = element.getElementsByTagName("name").item(0).getTextContent();
			String clas = element.getElementsByTagName("class").item(0).getTextContent();
			String score = element.getElementsByTagName("score").item(0).getTextContent();
		
		StuLeiJson stuLeiJson=new StuLeiJson();
		stuLeiJson.setId(id);
		//stuLeiJson.setName(name);
		stuLeiJson.setClas(clas);
		stuLeiJson.setScore(score);
		returnValue.add(stuLeiJson);
		
		}
		
		return returnValue;
	}
	
	
	
	// ��ѯ�ķ���
	public void select() {
		System.out.println("���\t����\t��Ŀ\t����");
		// ��ȡ ��ǩ���� student
		NodeList nodeList = document.getElementsByTagName("student");
		// ѭ�� ��� ���Ա�ǩ���� ������ �ڵ�
		System.out.println("--------------------------------");
		for (int i = 0; i < nodeList.getLength(); i++) {
			// ��ȡ��I���ڵ�
			Element element = (Element) nodeList.item(i);
			// ��ȡ�� ��ǩ ������
			String id = element.getAttribute("id");
			// ��ȡ��I���ڵ� �ĵ�I�� �ı�����
			String name = element.getElementsByTagName("name").item(0).getTextContent();
			String clas = element.getElementsByTagName("class").item(0).getTextContent();
			String score = element.getElementsByTagName("score").item(0).getTextContent();
			System.out.println(id + "\t" + name + "\t" + clas + "\t" + score);
		}
		System.out.println("--------------------------------");
	}

	// ɾ���ķ���
	public void delet() throws Exception {
		/*
		 * ���� �ķ���
		 */
		System.out.println("������Ҫɾ���Ŀ��ţ�");
		String num = s.nextLine();
		// ��ȡ ��ǩ���� student
		NodeList nodeList = document.getElementsByTagName("student");
		for (int i = 0; i < nodeList.getLength(); i++) {
			// ��ȡ��I���ڵ�
			Element element = (Element) nodeList.item(i);
			/**
			 * ��ȡ�� ��ǩ ������
			 */
			String id = element.getAttribute("id");
			// �����ǩ���� ���ı� ���
			if (id.equals(num)) {
				/**
				 * ɾ���ķ��� ���ø��ڵ�ɾ�� ��ǩ������ �ĵ�I�� �ӽڵ� ,�� �����⻹������Ҫ��ȡ�ϰ� �ĸ��ڵ����������ԡ�
				 * ���ϰ���ɾ��
				 */
				document.getDocumentElement().removeChild(element);
				System.out.println("ɾ���ɹ���");
				return;

			}
			System.out.println("û���ҵ�Ҫɾ�� �ı��!!");
		}
		save();
	}

	// �޸� �ķ���
	public void update() throws Exception {
		System.out.println("������Ҫ�޸ĵı�ţ�");
		String num = s.nextLine();

		NodeList nodeList = document.getElementsByTagName("student");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			String id = element.getAttribute("id");
			if (id.equals(id)) {
				System.out.println("�������µķ�����");
				String input = s.nextLine();
				// �õ� ������ ��ǩԪ�أ��ٸ���ǩԪ�����¸�ֵ
				element.getElementsByTagName("score").item(0).setTextContent(input);
				;
				return;

			}
			System.out.println("û���ҵ�Ҫ�޸ĵı��!!");
		}
		save();
	}

	// ���ӵķ���
	public void add() throws Exception {
		// System.out.println("������ѧ���Ŀ��ţ�");
		// String id = s.nextLine();
		/*
		 * �����Զ� ���ɵķ���
		 */
		String id = shengcheng();
		System.out.print("������ѧ�������֣�");
		String name = s.nextLine();
		System.out.print("������ѧ���Ŀγ̣�");
		String clas = s.nextLine();
		System.out.print("������ѧ���ķ�����");
		String score = s.nextLine();
		/**
		 * ��Ȼ�����ı����ݣ�������Ϊ�µ� ѧ�� û�� ���Ա�ǩ��û�б�ţ��γ̣�������Ԫ����Ϊ������ ����Ҫͨ���ĵ� .createElement
		 * ����һ����Ԫ�ؽڵ㣬һ�����Ա�ǩ
		 */
		Element a_student = document.createElement("student");
		/*
		 * Ȼ��������Ա�ǩ���� ������Ԫ�ؽڵ�
		 */
		Element a_name = document.createElement("name");
		a_name.setTextContent(name);
		Element a_clas = document.createElement("class");
		a_clas.setTextContent(clas);
		Element a_score = document.createElement("score");// !!!!!!!!!!�������ڣ����������ֺ�
															// xml������ֲ�һ��
		a_score.setTextContent(score);
		/*
		 * ���ң���Ԫ�ؽڵ� ������ ���� �û������ֵ
		 */
		a_student.appendChild(a_name);
		a_student.appendChild(a_clas);
		a_student.appendChild(a_score);

		a_student.setAttribute("id", id);
		document.getDocumentElement().appendChild(a_student);
		System.out.println("�����ɹ�!");
		save();
	}

	// �Զ����� ���ֱ�ŵ� ����
	public String shengcheng() {
		// һ��ѧ�ŵļ���
		List<Integer> bianhao = new ArrayList<Integer>();

		// ���õ����е�ѧ��
		NodeList student = document.getElementsByTagName("student");
		for (int i = 0; i < student.getLength(); i++) {
			Element element = (Element) student.item(i);

			String id = element.getAttribute("id");

			// ȥ��ǰ׺,
			String s = id.substring(1);
			bianhao.add(Integer.parseInt(s));
			// ������� ��ȫ����������
		}
		Integer max = 0;
		/*
		 * ���ж� ��ŵļ��� �Ƿ�����㣬���Ƿ�����������
		 */
		if (bianhao.size() == 0) {
			max = 0;
			// ֱ�ӵ��� Interger ���� �ķ�����

			/*
			 * Ȼ�� ��Ҫ���� ��ĸ����ͣ�
			 */
		} else {
			max = Collections.max(bianhao);

		}
		return "S" + (max + 1);
	}
	// ����ķ���

	public void save() throws Exception {

		Source xmlSource = new DOMSource(document);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		/*
		 * �������� ��� ��д�� �ܸ�д���������õ������ ��Ȼ��ص������
		 */
		Result result = new StreamResult(new File("src/com/qinguangfeng/entity086/Two_Score.xml"));
		transformer.transform(xmlSource, result);

		// OutputStream outputStream=new
		// FileOutputStream("src/com/qinguangfeng/entity086/Two_Score.xml");

	}

}
