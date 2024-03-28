<%-- 
    Document   : index
    Created on : 26 mar 2024, 12:36:49
    Author     : ignac
--%>

<%@page import="com.pruebatec2.barbeytoignacio_pruebatec2.logica.Ciudadano"%>
<%@page import="com.pruebatec2.barbeytoignacio_pruebatec2.logica.Turno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestión de Turnos</title>
    <!-- Agregar estilos de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Agregar Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f7ff;
            color: #000;
        }
        .card {
            background-color: #fff;
            border-color: #007bff;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
        <div class="container mt-4">
        <div class="card mb-3">
            <div class="card-body">
                <h2 class="card-title"><i class="bi bi-filter"></i> Listado de Ciudadanos</h2>
                <div class="results-table">
                    <% if (request.getAttribute("ciudadanos") != null) { %>
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nombre</th>
                                        <th>Dni</th>
                                        <th>Email</th>
                                        <th>Teléfono</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Ciudadano ciudadano : (List<Ciudadano>) request.getAttribute("ciudadanos")) { %>
                                        <tr>
                                            <td><%= ciudadano.getId() %></td>
                                            <td><%= ciudadano.getNombre()%></td>
                                            <td><%= ciudadano.getDni()%></td>
                                            <td><%= ciudadano.getEmail() %></td>
                                            <td><%= ciudadano.getTelefono()%></td>
                                        </tr>
                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                    <% } %>
                </div>
                <form action="CiudadanoSv" method="GET">
                    <button type="submit" class="btn btn-primary">Mostrar</button>
                </form>
            </div>
        </div>
        <div class="card mb-3">
            <div class="card-body">
                <h2 class="card-title"><i class="bi bi-plus-circle"></i> Nuevo Turno</h2>
                <form action="TurnoSv" method="POST">
                    <div class="form-group">
                        <label for="fecha">Fecha:</label>
                        <input type="date" class="form-control" id="fecha" name="fecha_turno">
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripción del Trámite:</label>
                        <input type="text" class="form-control" id="descripcion" name="descripcion_turno">
                    </div>
                    <div class="form-group">
                        <label for="ciudadano">Id del Ciudadano:</label>
                        <input type="long" class="form-control" id="ciudadano" name="id_ciudadano">
                    </div>
                    <button type="submit" class="btn btn-primary">Guardar Turno</button>
                </form>
            </div>
        </div>

        <div class="card mb-3">
            <div class="card-body">
                <h2 class="card-title"><i class="bi bi-person-plus"></i> Nuevo Ciudadano</h2>
                <form action="CiudadanoSv" method="POST">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre_ciudadano">
                    </div>
                    <div class="form-group">
                        <label for="dni">DNI:</label>
                        <input type="text" class="form-control" id="dni" name="dni_ciudadano">
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="text" class="form-control" id="email" name="email_ciudadano">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono:</label>
                        <input type="text" class="form-control" id="telefono" name="telefono_ciudadano">
                    </div>
                    <button type="submit" class="btn btn-primary">Guardar Ciudadano</button>
                </form>
            </div>
        </div>

        <div class="card mb-3">
            <div class="card-body">
                <h2 class="card-title"><i class="bi bi-filter"></i> Filtrado de Turnos</h2>
                <form action="TurnoSv" method="GET">
                    <div class="form-group">
                        <label for="fecha_filtro">Fecha:</label>
                        <input type="date" class="form-control" id="fecha_filtro" name="fecha_filtro">
                    </div>
                    <div class="form-group">
                        <label for="estado_filtro">Estado:</label>
                        <select class="form-control" id="estado_filtro" name="estado_filtro">
                            <option value="En Espera">En Espera</option>
                            <option value="Ya Atendido">Ya Atendido</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Filtrar Turnos</button>
                </form>
            </div>
        </div>

        <div class="results-table">
            <% if (request.getAttribute("turnos") != null) { %>
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title"><i class="bi bi-journal-text"></i> Turnos filtrados:</h3>
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Fecha</th>
                                        <th>Descripción del Trámite</th>
                                        <th>Ciudadano Asignado</th>
                                        <th>Estado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) { %>
                                        <tr>
                                            <td><%= turno.getFecha() %></td>
                                            <td><%= turno.getDescripcionTramite()%></td>
                                            <td><%= turno.getCiudadano().getNombre() %></td>
                                            <td><%= turno.getEstado() %></td>
                                        </tr>
                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>

    </div>
    <!-- Bootstrap JS y dependencias -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
