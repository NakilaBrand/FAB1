<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Inscription</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body class="container">
	<form method="post" action="inscription">
		<fieldset>
			<legend>Inscription</legend>
			<p>Vous pouvez vous inscrire via ce formulaire.</p>
			
			<label for="nom">Nom</label>
			<input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>"/>
			<br /> 
			<label for="prenom">Prenom</label>
			<input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>"/>
			<br /> 
			<label for="telephone">Telephone</label>
			<input type="text" id="telephone" name="telephone" value="<c:out value="${utilisateur.telephone}"/>"/>
			<br /> 
			<label for="email">Adresse email</label>
			<input type="email" id="email" name="email"	value="<c:out value="${utilisateur.email}"/>"/> 
			<br /> 
			<label for="password">Mot de passe</label> 
			<input type="password" id="password" name="password" value=""/> 
			<span class="erreur">${form.erreurs['motdepasse']}</span> 
			<br /> 
			<label for="confirmation">Confirmation du mot de passe </label> 
			<input type="password" id="confirmation" name="confirmation" value=""/>
			<br /> 
			
			<input type="submit" value="Inscription" class="sansLabel" />
			<br />

			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.erreurs}</p>
		</fieldset>
	</form>
</body>
</html>