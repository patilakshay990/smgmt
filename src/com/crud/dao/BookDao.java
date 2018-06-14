package com.crud.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.crud.modal.Book;
import com.crud.utility.Database;

public class BookDao {
Connection connection=null;

	public BookDao() throws SQLException {
	    connection=Database.getConnection();
	    
	}
	public void addBook(Book book) throws SQLException
	{
		
		PreparedStatement preparedStatement=null;
		boolean rowInserted=false;
		
		try
		{
			preparedStatement=connection.prepareStatement("insert into book(id book_name, author,price) values(?,?,?,?)");
			preparedStatement.setInt(1, book.getId());
			preparedStatement.setString(2, book.getName());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setFloat(4, book.getPrice());
			
			rowInserted=preparedStatement.executeUpdate()>0;
			
			
			
			
		}catch (Exception e) {
			System.out.println("Exception in add user"+ e.getMessage());
		}
		finally {
			connection.close();
		}
	}
	
	public void deleteBook(int userId) throws SQLException
	{
		PreparedStatement preparedStatement=null;
		try
		{
			preparedStatement=connection.prepareStatement("delete from book where book.id=?");
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			
			
		}catch(Exception e)
		{
		  System.out.println("Exception in delete Book"+ e.getMessage());	
		}
		finally {
			connection.close();
		}
	}
	
	public void updateUser(Book book) throws SQLException
	{
		PreparedStatement preparedStatement=null;
		try
		{
			preparedStatement=connection.prepareStatement("update book set book_name=?,author=?,price=?");
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setFloat(3, book.getPrice());
			preparedStatement.setInt(4, book.getId());
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in update book" + e.getMessage());
		}
		finally
		{
			Database.close();
		
		}
	}
	
	public java.util.List<Book> getAllBooks() throws SQLException
	{
		java.util.List<Book> list=new ArrayList<Book>();
		try
		{
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from Book");
			while(rs.next())
			{
				Book book=new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("book_name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				list.add(book);
			
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			Database.close();
			
		}
		
		
		return list;
		
	}

}
